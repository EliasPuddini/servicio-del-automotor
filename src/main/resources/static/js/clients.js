const app = Vue.createApp({
  data() {
      return {
          clientes: [],
          nuevoCliente: {
              name: '',
              document: { documentType: '', value: '' },
              user: { userName: '', password: '', isAdmin: false, isMechanic: false },
              clientType: {name: 'Basico'},
              vehicles:null,
              contacts:null
          },
          mostrarModal: false
      };
  },
  created() {
    this.getData();
  },
  methods: {
      getData() {
        axios.get("http://localhost:8080/api/clients")
        .then(response => {
            this.clientes = response.data
            console.log(this.clientes);
        })
        .catch(error => console.log(error));
      },
      postearDatos() {
          axios.post('/api/clients', this.nuevoCliente)
              .then(response => {
                  this.clientes.push(response.data);
                  this.contactos = '';
              })
              .catch(error => console.error(error));
      },
      abrirModal() {
          this.mostrarModal = true;
      },
      cerrarModal() {
          this.mostrarModal = false;
      }
  }
});
app.mount('#app');