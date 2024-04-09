const { createApp } = Vue;

const app = createApp({
  data() {
    return {
      turnos: [],
      turnosFiltrados: [],
      nombre: "",
      dni:"",
      fecha:"",
      hora:"",
      alineacionybalanceo: "",
      cambiodeaceite: "",
      lavado: "",
      pasados: false,
      buscadorDNI: "",
      buscadorNombre: ""
    };
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      axios
        .get("http://localhost:8080/api/turnos")
        .then(response => {
          this.turnos = response.data;
          console.log(this.turnos);
          this.turnosFiltrados = this.turnos;
        })
        .catch(error => {
          console.log(error);
        });
    },
    filtrar() {
      this.filtrarTurnos();
    },
    obtenerFecha(elemento){
        const elementoN = new Date(elemento.fecha);
        return elementoN.getDate();
    },
    obtenerHorario(elemento){
        const elementoN = new Date(elemento.fecha);
        const hora = elementoN.getHours();
        const minutos = elementoN.getMinutes();

        return hora + minutos;
    },
    filtrarTurnos() {

        let filtro1 = false;

        if(this.pasados){
            this.turnosFiltrados = this.turnos.filter(element => this.obtenerFecha(element) < this.fecha && this.obtenerHorario(element) < this.hora);
            this.filtro1 = true;
        }
        if(this.buscadorNombre != ""){
            
            if(this.filtro1){
                this.turnosFiltrados = this.turnosFiltrados.filter(element => element.cliente.nombre == this.buscadorNombre);
            }else{
                this.turnosFiltrados = this.turnos.filter(element => element.cliente.nombre == this.buscadorNombre)
            }
        }
        if(this.buscadorDNI != ""){

            if(this.filtro1){
                this.turnosFiltrados = this.turnosFiltrados.filter(element => element.cliente.dni.toString().includes(this.buscadorDNI.toString()));
            }else{
                this.turnosFiltrados = this.turnos.filter(element => element.cliente.dni.toString().includes(this.buscadorDNI.toString()));
            }
        }
        if(!this.pasados && this.buscadorDNI == "" && this.buscadorNombre == ""){
            this.turnosFiltrados = this.turnos;
            this.filtro1 = false;
        }
    },
    async postearDatos() {
      //TODO
        if(false){
        try {
            
            const response = await axios.post('http://localhost:8080/api/clients', {
                nombre: this.apellido,
                dni: this.dni,
                serviciosPrevios: "Normal"
            });
            console.log('Respuesta de la API:', response.data);
        } catch (error) {
            console.error('Error al enviar los datos:', error);
        }
      }else{
        alert("No se puede ingresar un cliente sin su nombre y dni.")
      }
        
    }
  }
}).mount("#app");