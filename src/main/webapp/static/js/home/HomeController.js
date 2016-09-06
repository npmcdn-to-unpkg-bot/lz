/**
 * Created by jan.husenica on 9/1/2016.
 */
angular.module('mainApp.home', [
    'mainApp.auth'
])
.config(function($stateProvider) {
    $stateProvider.state('home', {
        url: '/home',
        controller: 'HomeCtrl',
        templateUrl: 'static/js/home/template/home.html'
    });
})
.controller('HomeCtrl', function ($scope) {
    $scope.msg = "vitaj doma";
})