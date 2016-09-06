/**
 * Created by jan.husenica on 7/26/2016.
 */
'use strict';

userModule.factory('userService',[ '$resource', function($resource){
    // var userResource = $resource('/user/:id', {id: '@id'}, {
    //     update: {
    //         method: 'PUT'
    //     }
    // });
    // return userResource;
    var userResource = $resource('/user/', {}, {
        login : {
            method: 'POST',
            url: '/user/login',
            isArray: false
        }
    });
    return userResource;
}]);