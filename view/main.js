var admin = new Vue ({
  el : "#admin",
  data: {
    title: "Admin Menu",
    showAdminUser: true,
    showAdminBooks: false,
  }
}) 


var admin_user = new Vue({
  el: '#admin_user',
  data: {
    title: "Users",
    errorMsg: false,
    successMsg: false,
    showAddModal: false,
    showEditModal: false,
    showDeleteModal: false,
    usersArr: [],
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
        .then(data => this.usersArr= (data))
    },

    addUser: function () {
      //this.toPrint(this.newUser);
      //var formData = app.toFormData(this.newUser);
      fetch("http://www.localhost:8080/api/userResource/user", {
        method: 'POST',
        body: JSON.stringify(this.newUser),
        headers: new Headers({ 'content-type': 'application/json' }),
      }
      ).then(res => res.text())          // convert to plain text
        .then(text => console.log(text))
      this.getAllUsers();
    },


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

    updateUser: function () {
      //this.currentUser = this.selectUser(user);
      console.log(this.currentUser.firstName); 
      fetch("http://www.localhost:8080/api/userResource/user", {
        method: 'PUT',
        body: JSON.stringify(this.currentUser),
        headers: new Headers({ 'content-type': 'application/json' }),
      }
      ).then(res => res.text())          // convert to plain text
        .then(text => console.log(text))
        this.getAllUsers();
    },

    deleteUser: function () {
       fetch("http://www.localhost:8080/api/userResource/user", {
        method: 'DELETE',
        body: JSON.stringify(this.currentUser),
        headers: new Headers({ 'content-type': 'application/json' }),
      }
      ).then(res => res.text())          // convert to plain text
        .then(text => console.log(text))
        this.getAllUsers();
    },

    selectUser(user) {
      this.currentUser = user;
    }

    
  }



});


var admin_books = new Vue({
  el: "#admin_books"
});




var loginApp = new Vue({
  el: '#login-form',
  data: {
    username: '',
    password: '',
    usersArr: null
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
      this.usersArr.forEach(user => {
        console.log(user.userName, user.pwd)
        if (user.userName == this.username && user.pwd == this.password) {
          userFound = user;
        }
      })
      return userFound;
    }

  }

});