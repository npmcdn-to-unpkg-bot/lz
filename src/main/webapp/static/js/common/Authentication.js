/**
 * Created by jan.husenica on 8/8/2016.
 */

angular.module('mainApp.auth', [
    'ngResource',
    'ui.router',
    'angular-storage'
])
.factory('REnum', function () {
    return {role: {admin:'admin', user:1, client:2}}
})
.factory('AuthService', function ($resource, store, REnum){
    var authResource = $resource('/user/', {}, {
        login : {
            method: 'POST',
            url: '/user/login',
            isArray: false
        }
    });

    var authRoutines = {
        loginUser : function (credentials) {
            authResource.login(credentials,
                function (response) {
                    store.set('jwt', response.token);
                },
                function (data) {
                    var failure = 1;
                    alert("invalid credentials")
                }
            )
        },
        logoutUser : function () {
            store.remove('jwt');
        },
        isLoggedin : function () {
            if(store.get("jwt"))
            var res = store.get('jwt') != null;

            return res;
        }
    }


    return authRoutines;
});