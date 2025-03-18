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
            brands:[],
            nuevaMarca: null,
            nuevoModelo: null,
            models:[],
            contactModal: false,
            vehicleModal: false
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
            axios.get("api/vehicleThings/vehicleTypes")
                .then(response => {
                    this.vehicleTypes = response.data;
                    console.log(this.vehicleTypes);
                })
                .catch(error =>{
                    console.log(error);
                });
            axios.get("api/vehicleThings/brands")
                .then(response => {
                    this.brands = response.data;
                    console.log(this.brands);
                })
                .catch(error =>{
                    console.log(error);
                });
        },
        mostrarMensaje(mensaje, tipo) {
            this.mensaje = mensaje;
            this.alertClass = tipo === 'success' ? 'alert-success' : 'alert-danger';
            setTimeout(() => {
                this.mensaje = null;
            }, 3000); // Ocultar mensaje después de 3 segundos
        },
        postContact(){
            if(!this.contacts.some(c => c.email === this.nuevoContacto.email && c.phone === this.nuevoContacto.phone)){
                this.client.contacts.push(this.nuevoContacto);
                axios.patch(`api/clients`,this.client)
                    .then(response =>{
                        this.mostrarMensaje("Contacto agregado correctamente", "success");
                        this.closeContact();
                        this.contacts.push(this.nuevoContacto);
                    }). catch(error =>{
                        console.log(error);
                        this.mostrarMensaje("Error al agregar el contacto", "error");
                    })
            }else{
                alert(" Dicho contacto ya existe en el cliente. ");
                this.client.contacts.pop();
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
                    this.contacts = this.contacts.filter(contact => contact.id !== contactId);
                    this.mostrarMensaje("Contacto eliminado correctamente", "success");
                }).catch(error =>{
                    console.log(error);
                    this.mostrarMensaje("Error al eliminar el contacto", "error");
                });
        },
        postVehicle(){

            console.log(this.nuevoVehiculo)

            if(!this.vehicles.some(v => v.carPatent === this.nuevoVehiculo.carPatent)){
                this.client.vehicles.push(this.nuevoVehiculo);
                axios.patch(`api/clients`,this.client)
                    .then(response=>{
                        this.mostrarMensaje("Vehículo agregado correctamente", "success");
                        this.closeVehicle();
                    }). catch(error =>{
                        console.log(error);
                        this.clients.vehicles.pop();
                        this.mostrarMensaje("Error al agregar el vehículo", "error");
                    });
            }else{
                alert(" Dicho vehiculo ya existe en el cliente. ");
                
            }
        },
        openVehicle(){
            this.vehicleModal = true;
        },
        closeVehicle(){
            this.vehicleModal = false;
        },
        deleteVehicle(vehicleId){
            axios.delete(`api/vehicles/${vehicleId}`)
                .then(response =>{
                    console.log(response);
                    this.vehicles = this.vehicles.filter(vehicle => vehicle.id !== vehicleId);
                    this.mostrarMensaje("Vehículo eliminado correctamente", "success");
                }).catch(error =>{
                    console.log(error);
                    this.mostrarMensaje("Error al eliminar el vehículo", "error");
                });
        },
        searchModels(id){
            console.log(id);
            this.models = null;
            axios.get(`api/vehicleThings/brands/${id}/models`)
                .then(response => {
                    this.models = response.data;
                    console.log(this.models);
                })
                .catch(error =>{
                    console.log(error);
                });
        }
    }
});
app.mount("#app");