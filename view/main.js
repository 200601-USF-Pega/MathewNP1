// var admin = new Vue ({
//   el : "#admin",
//   data: {
//     title: "Admin Menu",
//     showAdminUser: true,
//     showAdminBooks: false,
//   }
// }) 


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
        .then(data => this.usersArr = (data))
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
      //console.log(this.currentUser.firstName);
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
  el: "#admin_books",
  data: {
    title: "Books",
    errorMsg: false,
    successMsg: false,
    showCounter: false,
    newCatalog: {
      title: "",
      author: {
        firstName: "",
        lastName: ""
      },
      catgeory: "",
      copies: ""
    },

    catalogArr: [],
    currentCatalog: {}
  },

  mounted: function () {
    this.getCatalog();
  },

  methods: {
    getCatalog: function () {
      console.log("fetching the catalog...")
      fetch("http://www.localhost:8080/api/catalog/books")
        .then(res => res.json())
        .then(data => this.catalogArr = (data))
    },

    addCopies: function (catalog) {
      this.selectCatalog(catalog);
      selectedCatalog = this.currentCatalog
      delete selectedCatalog.book.author.fullName;
      fetch("http://www.localhost:8080/api/catalog/book", {
        method: "POST",
        body: JSON.stringify(selectedCatalog),
        headers: new Headers({ 'content-type': 'application/json' }),

      })
      this.getCatalog();
    },

    deleteCopies: function (catalog) {
      this.selectCatalog(catalog);
      selectedCatalog = this.currentCatalog
      delete selectedCatalog.book.author.fullName;
      fetch("http://www.localhost:8080/api/catalog/book", {
        method: "DELETE",
        body: JSON.stringify(selectedCatalog),
        headers: new Headers({ 'content-type': 'application/json' }),
      })
      this.getCatalog();
    },

    selectCatalog: function (catalog) {
      this.currentCatalog = catalog;
    }


  }

});




var loginApp = new Vue({
  el: '#login-form',
  data: {
    username: '',
    password: '',
    usersArr: null
  },

  beforeCreate() {
    console.log("fetching users...")
    fetch("http://www.localhost:8080/api/userResource/users")
      .then(res => res.json())
      .then(data => this.usersArr = (data))
  },

  methods: {
    processForm: function () {
      console.log({ userName: this.username, password: this.password });
      //alert('Processing');
      var result = this.check();
      console.log("The access is: " + result.access)
      result ? alert("login success") : alert("username/password wrong.")

      if (result.access == "ADMIN") {
        window.location.href = '/admin.html';
      } else if (result.access == "PATRON") {
        window.location.href = "/patron.html";
      } else {
        window.location.href = "/banned.html";
      }
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


var patron_history = new Vue({
  el: "#patron_history",

  data: {
    title: "Patron Menu",
    errorMsg: false,
    successMsg: false,
    showCounter: false,
    currentUser: {
      access: "ADMIN",
      firstName: "Mathew",
      lastName: "Navin",
      pwd: "lolpro1992",
      userName: "nmathew13"
    },

    newHistory: {
      endDate: "",
      rental: {
        user: {
          userName: "",
          pwd: "",
          firstName: "",
          lastName: "",
          access: ""
        },
        startDate: "",
        book: {
          title: "",
          author: {
            firstName: "",
            lastName: "",
            fullName: "",
          },
          category: ""
        }
      }
    },


    historyArr: [
      {
        "endDate": "2020-06-17 05:56:55",
        "rental": {
          "user": {
            "userName": "nmathew13",
            "pwd": "lolpro1992",
            "firstName": "Mathew",
            "lastName": "Navin",
            "access": "ADMIN"
          },
          "startDate": "2020-06-17 05:56:45",
          "book": {
            "title": "Founding Giant",
            "author": {
              "firstName": "hajime",
              "lastName": "isayama",
              "fullName": "hajime isayama"
            },
            "category": "non-fiction"
          }
        }
      },
      {
        "endDate": "2020-06-17 06:11:32",
        "rental": {
          "user": {
            "userName": "nmathew13",
            "pwd": "lolpro1992",
            "firstName": "Mathew",
            "lastName": "Navin",
            "access": "ADMIN"
          },
          "startDate": "2020-06-17 05:55:02",
          "book": {
            "title": "crossroads",
            "author": {
              "firstName": "leo",
              "lastName": "tolstoy",
              "fullName": "leo tolstoy"
            },
            "category": "auto-biography"
          }
        }
      }
    ],
    
    currentHistory: {}
  },



});
