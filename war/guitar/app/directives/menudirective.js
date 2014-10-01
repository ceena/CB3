'use strict';

angular.module('ecat3App')
  .directive('ecMenu', function () {
    return {
      templateUrl: 'views/menu.html',
      restrict: 'EA',
      link: function postLink(scope, element, attrs) {
        console.log('this is the menuDirective directive');
      }
    };
  });
