const app = Vue.createApp({
    data() {
        return {
            clientes: [],
            nuevoCliente: {
                name: '',
                document: { documentType: {name:''}, value: '' },
                user: { userName: '', password: '', isAdmin: false, isMechanic: false },
                clientType: {name: 'Basico'},
                vehicles:null,
                contacts:null
            },
            mostrarModal: false,
            mensaje: '', // Variable para el mensaje
            statusCode: null // Almacenará el código de estado de la respuesta
        };
    },
    computed: {
      alertClass() {
        // Cambia la clase según el código de estado
        switch (this.statusCode) {
          case 200:
          case 202:
            return 'alert-success'; // Verde para éxito
          case 409:
            return 'alert-warning'; // Amarillo para conflicto
          default:
            return 'alert-danger'; // Rojo para error o desconocido
        }
      }
    },
    created() {
      this.getData();
    },
    methods: {
        getData() {
          axios.get("http://localhost:8080/api/clients")
          .then(response => {
              this.clientes = response.data;
              console.log(this.clientes);
          })
          .catch(error => {
              console.log(error);
              if (error.response && [200, 202, 409].includes(error.response.status)) {
                  this.mensaje = `Respuesta recibida con el código ${error.response.status}: ${error.response.data.message || ''}`;
                  this.statusCode = error.response.status;
              }
          });
        },
        postearDatos() {
            axios.post('/api/clients', this.nuevoCliente)
                .then(response => {
                  if (response.status === 200 || response.status === 202) {
                      this.mensaje = `Operación exitosa: ${response.status}`;
                      this.statusCode = response.status;
                      location.reload();
                  } else if (response.status === 409) {
                      this.mensaje = `Conflicto: El recurso ya existe.`;
                      this.statusCode = 409;
                  }
                })
                .catch(error => {
                    console.error(error);
                    if (error.response && [200, 202, 409].includes(error.response.status)) {
                        this.mensaje = `Error con el código ${error.response.status}: ${error.response.data.message}`;
                        this.statusCode = error.response.status;
                    }
                });
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