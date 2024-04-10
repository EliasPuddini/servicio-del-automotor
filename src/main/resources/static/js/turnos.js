const { createApp } = Vue;

const app = createApp({
  data() {
    return {
      turnos: [],
      turnosFiltrados: [],
      nombre: "",
      dni:"",
      patente: "",
      fecha:"",
      hora:"",
      alineacionybalanceo: "",
      cambiodeaceite: "",
      lavado: "",
      precio: "",
      pasados: false,
      buscadorDNI: "",
      buscadorNombre: "",
      buscadorPatente: "",
      futuros: false
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
    esPrevio(date1){

        let fecha1 = new Date(date1)
        let fecha2 = new Date()

        return fecha1.getTime() < fecha2.getTime();
    },
    esPosterior(date1){
        let fecha1 = new Date(date1)
        let fecha2 = new Date()

        return fecha1.getTime() >= fecha2.getTime();
    },
    obtenerLocalDateTime(date1,date2){

        let date = new Date(date1);
        const [hora, minutos] = date2.split(":");
        date.setHours(hora);
        date.setMinutes(minutos);
        
        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        let day = date.getDate();
        let hour = date.getHours();
        let minute = date.getMinutes();
        let second = date.getSeconds();

        // Crear un objeto LocalDateTime
        return localDateTime = year + "-" + month.toString().padStart(2, "0") + "-" + day.toString().padStart(2, "0") + "T" +
            hour.toString().padStart(2, "0") + ":" + minute.toString().padStart(2, "0") + ":" + second.toString().padStart(2, "0");

    },
    filtrarTurnos() {

        if(this.futuros){
            this.turnosFiltrados = this.turnos.filter(element => this.esPosterior(element.fecha));
        
        }
        if(this.pasados){
            this.turnosFiltrados = this.turnos.filter(element => this.esPrevio(element.fecha));
            
        }
            
            
        this.turnosFiltrados = this.turnosFiltrados.filter(element => element.cliente.nombre.toLowerCase().includes(this.buscadorNombre));
        
        this.turnosFiltrados = this.turnosFiltrados.filter(element => element.cliente.dni.toString().includes(this.buscadorDNI.toString()));

        this.turnosFiltrados = this.turnosFiltrados.filter(element => element.patente.toLowerCase().includes(this.buscadorPatente))
        
        if(!this.futuros && !this.pasados && this.buscadorDNI == "" && this.buscadorNombre == "" && this.buscadorPatente == ""){
            this.turnosFiltrados = this.turnos;
        }
    },
    todoBienPost(){
        
        let condicional1 = this.nombre != "" && this.dni != "";
        let condicional2 = this.alineacionybalanceo != "" && this.cambiodeaceite != "" && this.lavado !="";
        let condicional3 = this.precio != "" && this.fecha != "" && this.hora != "" && this.patente != ""

        return condicional1 && condicional2 && condicional3
    },
    async postearDatos() {
      
        if(this.todoBienPost()){
        try {
            
            const response = await axios.post('http://localhost:8080/api/turnos', {
                
                precio: this.precio,
                cliente: {
                    nombre: this.nombre,
                    dni:this.dni,
                    tipoCliente: "Normal"
                },
                servicio:{
                    alineacionybalanceo: this.alineacionybalanceo,
                    aceiteyfiltro: this.cambiodeaceite,
                    lavado: this.lavado
                },
                fecha: this.obtenerLocalDateTime(this.fecha,this.hora),
                patente: this.patente

            });
            console.log('Respuesta de la API:', response.data);
        } catch (error) {
            console.error('Error al enviar los datos:', error);
        }
      }else{
        alert("No se puede ingresar el turno por errores en los campos del turno.")
      }
        
    }

  }
}).mount("#app");