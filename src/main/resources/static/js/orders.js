const app = Vue.createApp({
  data() {
      return {
          turnos: [],
          clientes: [],
          vehiculosFiltrados:[],
          servicios: [],
          mostrarModal: false,
          order:{
            date: '',
            hour: '',
            vehicle:{
              carPatent:''
            },
            client:{
              id:null
            },
            service:{
              name:''
            },
            finalPrice: null,
            bonus: []
          }
      
        };
  },
  created() {
    this.getData();
  },
  methods: {
      getData() {
        axios
          .get("http://localhost:8080/api/order")
          .then(response => {
            this.turnos = response.data;
            console.log(this.turnos);
          })
          .catch(error => {
            console.log(error);
          });
        axios.get("http://localhost:8080/api/clients")
          .then(response => {
              this.clientes = response.data
              console.log(this.clientes);
          })
          .catch(error => console.log(error));
        axios.get("http://localhost:8080/api/services")
          .then(response => {
              this.servicios = response.data
              console.log(this.servicios);
          })
          .catch(error => console.log(error));
      },
      formatFecha(fecha) {
        return new Date(fecha).toLocaleDateString("es-AR");
      },
      abrirModal() {
        this.mostrarModal = true;
      },
      cerrarModal() {
        this.mostrarModal = false;
      },
      async cargarVehiculos() {
        if (!this.order.client.id) return;
        try {
            const response = await axios.get(`/api/clientes/${this.order.client.id}/vehiculos`);
            this.vehiculos = response.data;
        } catch (error) {
            console.error("Error al cargar vehículos:", error);
        }
    },
    postearOrden(){

      const clientePosteado = this.clientes.find(c => c.id === this.order.client.id);
      this.order.client = clientePosteado;
      const vehiculoPosteado = this.order.client.vehicles.find(c => c.carPatent === this.order.vehicle.carPatent);
      this.order.vehicle = vehiculoPosteado;
      const servicioPosteado = this.servicios.find(s => s.name === this.order.service.name);
      this.order.service = servicioPosteado;

      // Formatear la hora a "HH:mm:ss"
      if (this.order.hour) {
        this.order.hour = this.order.hour.length === 5 ? `${this.order.hour}:00` : this.order.hour;
      }


      axios.post('/api/order', this.order)
            .then(response => {
                
            })
            .catch(error => console.error(error));
    },
    filtrarVehiculos() {
      const clienteSeleccionado = this.clientes.find(c => c.id === this.order.client.id);
      
      if (clienteSeleccionado && clienteSeleccionado.vehicles.length > 0) {
          this.vehiculosFiltrados = clienteSeleccionado.vehicles;
      } else {
          this.vehiculosFiltrados = [];
          alert("El cliente seleccionado no tiene vehículos registrados.");
      }
  },
  }
});
app.mount('#app');