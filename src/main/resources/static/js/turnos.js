const { createApp } = Vue;

const app = createApp({
  data() {
    return {
      turnos: [],
      turnosFiltrados: [],
      clientes: [],
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
          this.turnosFiltrados = this.turnos;
        })
        .catch(error => {
          console.log(error);
        });
      axios
        .get("http://localhost:8080/api/clients")
        .then(response => {
          this.clientes = response.data;
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
    temporalidad(flag){
      switch(flag){
        case 1:
          return this.turnos;
        case 2:
          return this.turnosFiltrados;
        default:
          return this.turnos;
      }
    },
    filtrarTurnos() {

      this.turnosFiltrados = this.turnos;

      if(this.futuros && this.pasados){
        this.turnosFiltrados = [];
        return;
      }
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
    noCoinciden(){
        let coincidencia = true;
        let clienteGuardado = clientes.filter(cliente => cliente.dni == this.dni);
        
        if(this.nombre != clienteGuardado.nombre && clienteGuardado != null){
          return false;
        }
    },
    async postearDatos() {
      
      if(this.todoBienPost()){
        try {

            if(this.noCoinciden()){
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
            }else{
              alert("El dni y el nombre no corresponden a lo ingresado en la base de datos.");
            }
            
            
        } catch (error) {
            console.error('Error al enviar los datos:', error);
        }
      }else{
        alert("No se puede ingresar el turno por errores en los campos del turno.")
      }
        
    }

  }
}).mount("#app");