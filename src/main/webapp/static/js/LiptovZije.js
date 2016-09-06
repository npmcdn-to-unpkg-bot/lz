/**
 * Created by jan.husenica on 7/26/2016.
 */
'use strict';

angular.module('mainApp',[
    'mainApp.events',
    'mainApp.users',
    'mainApp.articles',
    'mainApp.home',
    'mainApp.auth',
    'angular-jwt',
    'angular-storage',
    'ngResource'
])
.config( function ($urlRouterProvider, jwtInterceptorProvider, $httpProvider) {
    $urlRouterProvider.otherwise('/');

    jwtInterceptorProvider.tokenGetter = function(store) {
        return store.get('jwt');
    }

    $httpProvider.interceptors.push('jwtInterceptor');
})
// .run(function($rootScope, $state, store, jwtHelper) {
//     $rootScope.$on('$stateChangeStart', function(e, to) {
//         if (to.data && to.data.requiresLogin) {
//             if (!store.get('jwt') || jwtHelper.isTokenExpired(store.get('jwt'))) {
//                 e.preventDefault();
//                 $state.go('login');
//             }
//         }
//     });
// })
.controller('AppController', function AppController (AuthService, $location, $scope) {
    this.credentials = {};
    this.login = AuthService.loginUser.bind(this, this.credentials);
    this.logout = AuthService.logoutUser;
    this.showLogin = showLoginForm;
    this.getClass = highlightMenu;

    function highlightMenu (path) {
        return ($location.path().substr(0, path.length) === path) ? 'active' : '';
    }

    function showLoginForm() {
        var logged = AuthService.isLoggedin();
        return !logged;
    }
});