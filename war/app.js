var app = angular.module('x', ['ui.codemirror']);
app.controller('mc',function($scope,$http){
	$scope.creator = 'Srinivas Reddy';
	$scope.code = ' //write your main method code here \n '+
		'	System.out.println("Integer Arithmetic");' +
		'\n    int a = 1 + 1;\n    int b = a * 3;\n    int c = b / 4;\n    int d = c - a; \n    int e = -d;'+
    '\n    System.out.println("a = " + a);\n    System.out.println("b = " + b);\n    System.out.println("c = " + c);\n    System.out.println("d = " + d);\n    System.out.println("e = " + e);\n';
    
    'int x = 42;\n    System.out.println("x mod 10 = " + x % 10);\n    double y = 42.25;\n'+

    '    System.out.println("y mod 10 = " + y % 10);' +
			'\n\n';
	
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
		$scope.code = ' //write your main method code here \n '+
		'	System.out.println("Integer Arithmetic");' +
		'\n    int a = 1 + 1;\n    int b = a * 3;\n    int c = b / 4;\n    int d = c - a; \n    int e = -d;'+
    '\n    System.out.println("a = " + a);\n    System.out.println("b = " + b);\n    System.out.println("c = " + c);\n    System.out.println("d = " + d);\n    System.out.println("e = " + e);\n';
    
    'int x = 42;\n    System.out.println("x mod 10 = " + x % 10);\n    double y = 42.25;\n'+

    '    System.out.println("y mod 10 = " + y % 10);' +
			'\n\n';
	
	};
	
});