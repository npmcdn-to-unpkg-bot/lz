/**
 * Created by jan.husenica on 7/26/2016.
 */
'use strict';

userModule.controller('userController', ['$scope', 'userService', function($scope, userService) {
    var self = this;
    self.user = {id:null,username:'',address:'',email:''};
    self.users = [];

    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.submit = loginUser;

    fetchAllUsers();

    function loginUser() {

        var credentials= {};
        credentials.username = this.name;
        credentials.password = this.pass;

        userService.login(credentials,
            function (data) {
                var success = 1;
                debugger;
            },
            function () {
                var failure = 1;
                debugger;
            }
        )
    }

    function fetchAllUsers() {
        self.users = userService.query(
            function (data) {       // success

            },
            function (response) {   // failure
                debugger
            }
        );
    };

    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);

            var newUser = new userService(self.user);
            newUser.$save(
                function (data) {       // success callback
                    newUser.id = data.id;
                    self.users.push(newUser);
                },
                function (response) {   // error callback
                    debugger
                }
            );
        }else{
            console.log('User updated with id ', self.user.id);

            userService.update({id: self.user.id}, self.user,
                function (data) {       // success
                    fetchAllUsers();
                },
                function (response) {   // failure
                    debugger
                }
            );
        }
        reset();
    };

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    };

    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            self.reset();
        }
        userService.delete(
            {id:id},
            function (data) {   // success
                fetchAllUsers();
            },
            function (data) {   // failure
                debugger
            }
        );
    };


    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);