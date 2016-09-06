/**
 * Created by jan.husenica on 9/1/2016.
 */
angular.module('mainApp.events', [
    'mainApp.auth'
])
.config(function($stateProvider) {
    $stateProvider.state('events', {
        url: '/events',
        controller: 'EventsCtrl as ectrl',
        templateUrl: 'static/js/events/template/events.html'
    });
})
.factory('EventService', function ($resource) {
    var eventService = $resource('/event/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
    return eventService;
})
.controller('EventsCtrl', function ($scope, EventService) {
    $scope.msg = "vitaj v eventoch";

    this.myText = "toto je z EventsCtrl";

    this.testf = function () {
        EventService.query(
            function (data) {
                var success = 1;
                debugger;
            },
            function () {
                var failure = 1;
            }
        )
    }
});