const {createApp} = Vue

const app = createApp({

    data(){
        return{
            clientes: [],
            contenedorClientes: ""
        }
    },
    created(){
        this.getData()
    },
    methods:{
        getData(){
            axios.get("http://localhost:8080/api/clients")
            .then(response => {
                this.clientes = response.data;
                console.log(this.clientes);
            })
            .catch(error =>  {console.log(error)});
        }
    }


}).mount("#app")