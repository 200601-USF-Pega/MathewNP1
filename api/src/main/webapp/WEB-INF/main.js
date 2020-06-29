var app = new Vue({
  el: '#app',
  data: {
    errorMsg: false,
    successMsg: false,
    showAddModal: false,
    showEditModal: false,
    showDeleteModal: false,
    usersObj: null,
    newUser: {
      userName: "",
      pwd: "",
      firstName: "",
      lastName: "",
      access: ""
    },
    currentUser: {}
  },
  mounted: function () {
    this.getAllUsers();
  },

  methods: {
    getAllUsers: function () {
      console.log("fetching users...")
      fetch("http://www.localhost:8080/api/userResource/users")
        .then(res => res.json())
        .then(data => this.usersObj = (data))
    },

     addUser: function () {
       //this.toPrint(this.newUser);
       //var formData = app.toFormData(this.newUser);
       fetch("http://www.localhost:8080/api/userResource/newUser", {
         method: 'POST',
         body: JSON.stringify(this.newUser),
         headers: new Headers({'content-type': 'application/json'}),
       }
       ).then(res => res.text())          // convert to plain text
         .then(text => console.log(text))
       this.getAllUsers();
     },

    // addUser: function () {
    //   const { data } = curly.post('http://www.localhost:8080/api/userResource/newUser', {
    //     postFields: JSON.stringify(this.newUser),
    //     httpHeader: [
    //       'Content-Type: application/json',
    //       'Accept: application/json'
    //     ],
    //   })
    // },

    // addUser: function() {
    //     var req = new XMLHttpRequest();

    //             req.open("POST", "http://localhost:8080/api/userResources/newUser", true);
    //             req.setRequestHeader('Content-Type', 'application/json');
    //             req.send(JSON.stringify(this.newUser));
    // },

    toPrint(obj) {
      for (var i in obj) {
        console.log(obj[i])
      }
    },
    toFormData: function (obj) {
      var fd = new FormData();
      for (var i in obj) {
        fd.append(i, obj[i]);
      }
      return fd
    },
    deleteUser: function () {

    },
    editUser: null
  }



});

var loginApp = new Vue({
  el: '#login-form',
  data: {
    username: '',
    password: '',
    usersObj: null
  },

  beforeCreate() {
    // console.log("fetching users...")
    // fetch("http://www.localhost:8080/api/userResource/users")
    // .then(res => res.json())
    // .then(data => this.usersObj = (data))
  },

  methods: {
    processForm: function () {
      console.log({ userName: this.username, password: this.password });
      //alert('Processing');
      var result = this.check();
      console.log("The result is: " + result)
      result ? alert("login success") : alert("username/password wrong.")
      console.log(result.access)
    },

    check: function () {
      var userFound;
      this.usersObj.forEach(user => {
        console.log(user.userName, user.pwd)
        if (user.userName == this.username && user.pwd == this.password) {
          userFound = user;
        }
      })
      return userFound;
    }

  }

});