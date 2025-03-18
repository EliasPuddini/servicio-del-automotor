const app = Vue.createApp({
    data(){
        return{
            brands:[],
            models: [],
            modelsF:[],
            modelModal: false,
            nuevaMarca: '',
            nuevaMarcaHabilitada: false,
            nuevoModelo:{
                name:"",
                brand:{
                    name:""
                }
            },
            newBrand:{
                name:""
            }
        }
    },
    created(){
        this.getData();
    },
    methods:{
        getData(){
            axios.get("api/vehicleThings/brands")
                .then(response =>{
                    this.brands = response.data;
                    this.brands.push(newBrand);
                    console.log(this.brands);
                }). catch(error =>{
                    console.log(error);
                });
            axios.get("api/vehicleThings/models")
                .then(response =>{
                    this.models = response.data;
                    console.log(this.models);
                }). catch(error =>{
                    console.log(error);
                });
        },
        openModel(){
            this.modelModal = true;
        },
        closeModel(){
            this.modelModal = false;
        },
        postModel(){
            axios.post("api/vehicleThings/models",this.nuevoModelo)
                .then(response =>{
                    console.log(response);
                    this.mostrarMensaje("Modelo guardado correctamente", "success");
                    this.closeModel();
                }). catch(error =>{
                    console.log(error);
                    this.mostrarMensaje("Error al guardar el modelo. ", "error");
                });
        },
        deleteModel(id){
            axios.delete(`api/vehicleThings/models/${id}`)
                .then(response =>{
                    console.log(response);
                    this.mostrarMensaje("Modelo eliminado correctamente", "success");
                }). catch(error =>{
                    console.log(error);
                    this.mostrarMensaje("Error al eliminar el modelo. ", "error");
                });
        },
        mostrarMensaje(mensaje, tipo) {
            this.mensaje = mensaje;
            this.alertClass = tipo === 'success' ? 'alert-success' : 'alert-danger';
            setTimeout(() => {
                this.mensaje = null;
            }, 3000); // Ocultar mensaje después de 3 segundos
        }
    }
})

app.mount("#app")