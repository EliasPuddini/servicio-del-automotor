const app = Vue.createApp({
    data() {
        return {
            client: null,
            vehicles:[],
            contact: [],
            mensaje: null,
            nuevoContacto: {
                email:"",
                phone:""
            },
            nuevoVehiculo:{
                carPatent: "",
                kilometres: null,
                model: {
                    name: "",
                    brand: {
                        name:""
                    }
                },
                vehicleType:{
                    name:""
                }
            },
            vehicleTypes:[]
        }
    },
    created() {
        const param = new URLSearchParams(window.location.search);
        const clientID = param.get("id");
        console.log(clientID);
        this.getData(clientID);
    },
    methods: {
        getData(id) {
            axios.get(`api/clients/${id}`)
                .then(response => {
                    this.client = response.data;
                    this.vehicles = this.client.vehicles;
                    this.contacts = this.client.contacts;
                    console.log(this.client);
                })
                .catch(error => {
                    console.error(error);
                });
            axios.get("api/vehicleTypes")
                .then(response => {
                    this.vehicleTypes = response.data;
                    console.log(this.vehicleTypes);
                })
                .catch(error =>{
                    console.log(error);
                })
        },
        postContact(){
            if(!contactos.some(c => c.email === nuevoContacto.email && c.phone === nuevoContacto.phone)){
                this.client.contacts.add(this.nuevoContacto);
                axios.patch(`api/clients`,this.client);
            }else{
                alert(" Dicho contacto ya existe en el cliente. ");
            }
        },
        postVehicle(){
            if(!contactos.some(c => c.email === nuevoContacto.email && c.phone === nuevoContacto.phone)){
                this.client.vehicles.add(this.nuevoVehiculo);
                axios.patch(`api/clients`,this.client);
            }else{
                alert(" Dicho vehiculo ya existe en el cliente. ");
            }
        }
    }
});
app.mount("#app");