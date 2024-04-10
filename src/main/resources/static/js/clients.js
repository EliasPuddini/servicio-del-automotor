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
  computed: {
    clientesFiltradosData() {
      if (this.buscadorNombre == "" && this.buscadorDNI == "") {
        return this.clientes;
      }
      if (this.buscadorNombre != "" && this.buscadorDNI != "") {
        return this.filtrarPorNombre().filter(elemento =>
          this.filtrarPorDNI().includes(elemento)
        );
      }

      if (this.buscadorNombre != "") {
        return this.filtrarPorNombre();
      }
      if (this.buscadorDNI != "") {
        console.log("llego a dni");
        return this.filtrarPorDNI();
      }
    }
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
      this.clientesFiltrados = this.clientesFiltradosData;
    },
    filtrarPorNombre() {
      if (this.buscadorNombre && typeof this.buscadorNombre === 'string') { // Verificar si buscadorNombre tiene un valor y es un string
        const busqueda = this.buscadorNombre.toLowerCase();
        return this.clientes.filter(cliente =>
          cliente.nombre.toLowerCase().includes(busqueda)
        );
      } else {
        return this.clientes; // Devolver todos los clientes si no hay búsqueda válida
      }
    },
    filtrarPorDNI() {
      if (this.buscadorDNI) {

        return this.clientes.filter(cliente => cliente.dni.toString().includes(this.buscadorDNI));
      } else {
        return this.clientes; // Devolver todos los clientes si no hay búsqueda válida
      }
    },
    async postearDatos() {
      if(this.nombre == "" && this.dni == ""){
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
      }else{
        alert("No se puede ingresar un cliente sin su nombre y dni.")
      }
        
    }
  }
}).mount("#app");