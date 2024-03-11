window.addEventListener('load',() =>{

    const app = Vue.createApp({
        data() {
            return {
                clients: [],
                client:{
                    id: '',
                    nombre: '',
                    tipoCliente: '',
                    serviciosPrevios: ''
                },
                errorToats: null,
                errorMsg: null,
            }
        },
        methods: {
            getData: async function () {
                try {
                    const response = await fetch('/api/clients');
                    const data = await response.data;
                    this.clients = data;
                    console.log(this.clients);
                } catch (error) {
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                }
            },
            formatDate: function (date) {
                return new Date(date).toLocaleDateString('en-gb');
            }
        },
        mounted: function(){
            this.getData();
        }

    })
    app.mount('#app')
});