windows.addEventListener('load',() =>{

    const app = vue.createApp({
        data() {
            return {
                clientInfo: {},
                errorToats: null,
                errorMsg: null,
            }
        },
        methods: {

            

            getData: function () {
                axios.get("/api/clients/")
                    .then((response) => {
                        //get client ifo
                        this.clientInfo = response.data;
                    })
                    .catch((error) => {
                        // handle error
                        this.errorMsg = "Error getting data";
                        this.errorToats.show();
                    })
            },
            formatDate: function (date) {
                return new Date(date).toLocaleDateString('en-gb');
            }
        }     

    })
    app.mount('#app')
});

/*Vue.createApp({
    data() {
        return {
            clientInfo: {},
            errorToats: null,
            errorMsg: null,
        }
    },
    methods: {
        getData: function () {
            axios.get("/api/clients/")
                .then((response) => {
                    //get client ifo
                    this.clientInfo = response.data;
                })
                .catch((error) => {
                    // handle error
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                })
        },
        formatDate: function (date) {
            return new Date(date).toLocaleDateString('en-gb');
        }
    },
    mounted: function () {
        this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
        this.getData();
        new DataTable('#example');
    }
}).mount('#app')*/