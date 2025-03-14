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
            vehicleTypes:[],
            contactModal: false,
            vehicleModal: true
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
            if(!this.contacts.some(c => c.email === this.nuevoContacto.email && c.phone === this.nuevoContacto.phone)){
                this.client.contacts.push(this.nuevoContacto);
                axios.patch(`api/clients`,this.client)
                    .then(response =>{
                        
                    }). catch(error =>{
                        console.log(error);
                    })
            }else{
                alert(" Dicho contacto ya existe en el cliente. ");
                this.client.contacts.pop();
            }
        },
        postVehicle(){
            if(!this.vehicles.some(v => v.carPatent === nuevoVehiculo.carPatent)){
                this.client.vehicles.push(this.nuevoVehiculo);
                axios.patch(`api/clients`,this.client);
            }else{
                alert(" Dicho vehiculo ya existe en el cliente. ");
                this.clients.contacts.pop();
            }
        },
        openContact(){
            this.contactModal = true;
        },
        closeContact(){
            this.contactModal = false;
        },
        deleteContact(contactId){
            axios.delete(`api/contacts/${contactId}`)
                .then(response =>{
                    console.log(response);
                }).catch(error =>{
                    console.log(error);
                });
        },
        deleteVehicle(vehicleId){
            axios.delete(`api/vehicle/${vehicleId}`)
                .then(response =>{
                    console.log(response);
                }).catch(error =>{
                    console.log(error);
                });
        }
    }
});
app.mount("#app");