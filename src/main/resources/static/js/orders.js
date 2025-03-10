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
      axios.post('/api/order', this.nuevoCliente)
            .then(response => {
                this.clientes.push(response.data);
            })
            .catch(error => console.error(error));
    },
    filtrarVehiculos(){

    }
  }
});
app.mount('#app');