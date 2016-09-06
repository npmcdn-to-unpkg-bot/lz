/**
 * Created by jan.husenica on 9/1/2016.
 */
angular.module('mainApp.users', [
    'mainApp.auth'
])
.config(function($stateProvider) {
    $stateProvider.state('users', {
        url: '/users',
        controller: 'UsersCtrl',
        templateUrl: 'static/js/users/template/users.html'
    });
})
.controller('UsersCtrl', function ($scope) {
    $scope.msg = "vitaj v useroch";
})