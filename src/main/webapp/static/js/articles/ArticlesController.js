/**
 * Created by jan.husenica on 9/1/2016.
 */
angular.module('mainApp.articles', [
    'mainApp.auth'
])
.config(function($stateProvider) {
    $stateProvider.state('articles', {
        url: '/articles',
        controller: 'ArticlesCtrl as actrl',
        templateUrl: 'static/js/articles/template/articles.html'
    });
})
.controller('ArticlesCtrl', function ($scope) {
    $scope.msg = "vitaj v clankoch";
    this.test = "toto je z ArticlesCtrl"
})