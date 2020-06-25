var userArr = {}


app = new Vue({
    el: "#app",
    data() {
        return {
            test: "Hello",
            usersObj: null
        }
    },
    mounted() {
        fetch("http://www.localhost:8080/api/userResource/users")
            .then(res => res.json())
            .then(data => this.usersObj = data)
    }


});