const { createApp } = Vue;

const app = createApp({
  data() {
    return {
      clientes: [],
      clientesFiltrados: [],
      contenedorClientes: "",
      apellido: "",
      dni: "",
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
        .get("http://localhost:8080/api/clients")
        .then(response => {
          this.clientes = response.data;
          console.log(this.clientes);
          this.clientesFiltrados = this.clientes;
        })
        .catch(error => {
          console.log(error);
        });
    },
    filtrar() {
      this.clientesFiltrados = this.clientes;
      this.clientesFiltrados = this.clientesFiltrados.filter(cliente =>cliente.nombre.toLowerCase().includes(this.buscadorNombre.toLowerCase()));
      this.clientesFiltrados = this.clientesFiltrados.filter(cliente => cliente.dni.toString().includes(this.buscadorDNI));
    },
    isBlank(str){
      return !str || /^\s*$/.test(str); //la segunda parte es una expresión regular
    },
    todoBien(){

      let cliente = this.clientes.filter(cliente => cliente.dni.toString() == this.dni);

      if(this.isBlank(this.dni) || this.isBlank(this.nombre)){
        alert("Hay campos de introducción vacios.")
        return false;
      }

      if(cliente.length != 0){
        alert("El dni ya existe.");
        console.log(cliente);
        return false;
      }

      if(!this.isBlank(this.dni) && this.isBlank(this.nombre) && cliente.length == 0){
        return true;
      }
    },
    async postearDatos() {
      if(this.todoBien()){
        try {
            
            const response = await axios.post('http://localhost:8080/api/clients', {
                nombre: this.apellido,
                dni: this.dni,
                tipoCliente: "Normal"
            });
            console.log('Respuesta de la API:', response.data);
        } catch (error) {
            console.error('Error al enviar los datos:', error);
        }
      }
        
    }
  }
}).mount("#app");