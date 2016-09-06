/**
 * Created by jan.husenica on 7/26/2016.
 */
'use strict'

angular.module('events',[])
    .config(function($routeProvider) {
        $routeProvider
            .when('/calendar', {redirectTo: 'events/calendar/templates/calendar.html'})
        ;
    });
