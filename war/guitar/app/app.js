'use strict';

angular.module('guitarApp', [ 'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngRoute'
])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/edit_guitar', {
        templateUrl: 'views/first.html',
        controller: 'MainCtrl'
      })
      .otherwise({ redirectTo: '/edit_guitar' });
  })

 .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });