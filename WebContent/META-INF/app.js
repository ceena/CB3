var app = angular.module('x', ['ui.codemirror']);
app.controller('mc',function($scope,$http){
	$scope.creator = 'Srinivas Reddy';
	$scope.code = '  public class Hello{\n\n'+
		'\tpublic static void Main(String[] args){\n' + 
			'\t\t\tSystem.out.println("This is cool stuff.");\n		}\n\n	}\n';
	
	$scope.runCode= function(){
		
		 $http({method: 'POST', data:$scope.code, url: 'sri03051986'}).
		    success(function(data, status, headers, config) {
		      // this callback will be called asynchronously
		      // when the response is available
		    	$scope.code = data;
		    }).
		    error(function(data, status, headers, config) {
		      // called asynchronously if an error occurs
		      // or server returns response with an error status.
		    });
	};
	
	$scope.resetCode = function(){
		$scope.code = '  public class Hello{\n\n'+
		'\tpublic static void Main(String[] args){\n' + 
			'\t\t\tSystem.out.println("This is cool stuff.");\n		}\n\n	}\n';
	};
	
});