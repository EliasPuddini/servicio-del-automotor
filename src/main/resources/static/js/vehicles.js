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
                }). catch(error =>{
                    console.log(error);
                });
        },
        deleteModel(id){
            axios.delete(`api/vehicleThings/models/${id}`)
                .then(response =>{
                    console.log(response);
                }). catch(error =>{
                    console.log(error);
                });
        },
        newBrandCheck(){
            this.newBrand = !this.newBrand;
        }
    }
})

app.mount("#app")