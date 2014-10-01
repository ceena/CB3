'use strict';

angular.module('ecat3App')
  .directive('ecHeader', ['$log',function ($log) {
    return {
      templateUrl: 'views/header.html',
      restrict: 'EA',
      controller: function($scope, $element, $attrs, $transclude) {


      	$scope.$log = $log;
      	$scope.query = 'Enter course name or topic';
        $scope.menuitems = [{class:'brand',name:'Beginner'},
        {class:'no_brand',name:'Intermediate'}, {class:'no_brand',name:'Advanced'}, {class:'no_brand',name:'Cheatsheet'}, {class:'no_brand',name:'Help'}];



      	$scope.compare = function(){
      		$log.log('compare action');
      	};
	$scope.search = function(){
      		$log.log('search action: '+$scope.query);
      	}
      },
      link: function postLink(scope, element, attrs) {
        console.log('this is the headDirective directive');
      }
    };
  }])

    .directive('ecHeader2', ['$log',function ($log) {
    return {
      templateUrl: 'views/header2.html',
      restrict: 'EA',
      controller: function($scope, $element, $attrs, $transclude) {


        $scope.$log = $log;
        $scope.query = 'Search courses';
        $scope.menuitems = [{class:'brand',name:'Beginner'},
        {class:'no_brand',name:'Intermediate'}, {class:'no_brand',name:'Advanced'}, {class:'no_brand',name:'Cheatsheet'}, {class:'no_brand',name:'Help'}];



        $scope.compare = function(){
          $log.log('compare action');
        };
  $scope.search = function(){
          $log.log('search action: '+$scope.query);
        }
      },
      link: function postLink(scope, element, attrs) {
        console.log('this is the headDirective directive');
      }
    };
  }]);