fetch("http://www.localhost:8080/api/userResource/users")
.then(res =>{
    if(res.ok) {
        console.log("Sucess")
    } else {
        console.log("Not Sucessful");
    }
})
.then(data => console.log(data))

app = new Vue({
    el: "#app",
    data: {
        test: "hello"
    }

});