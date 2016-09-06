/**
 * Created by jan.husenica on 7/27/2016.
 */
var userModule = angular.module('userModule', ['ngRoute', 'ngResource'])
    .config(function($routeProvider) {
        //$locationProvider.html5Mode(true);
        $routeProvider
            .when('/users', {templateUrl: 'static/js/users/templates/users.html'})
            .when('/users/new', {templateUrl: 'static/js/users/templates/user_edit.html'})
            /*
            .when('/users/:id', {templateUrl: 'users/templates/user_detail.html'})
            .when('/users/:id/edit', {templateUrl: 'users/templates/user_edit.html'})
            */
        ;
    });