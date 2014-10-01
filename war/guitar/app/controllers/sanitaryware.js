'use strict';

angular.module('ecat3App')
  .controller('SanitarywareCtrl', function ($scope,$http) {
    
    $scope.setQuery = function (r) {
		alert(r);
	};
	
	$scope.use_case = [];
	
	$scope.products = [];
	  $http.get('products.json').success(function(data){
		  	$scope.products = data;
		  	$scope.products_filtered = $scope.products;
		  	for (var prod in $scope.products){
		  		if($scope.use_case.indexOf($scope.products[prod].use_case) === -1 && $scope.products[prod].use_case != ''){
		  			$scope.use_case.push($scope.products[prod].use_case);
		  		}
		  	};
		  });
	  
	  
	
	$scope.brand = ['Parryware','Hindware','Jaguar'];
	$scope.filter = {'brand':[],'use_case':[]};
	
	$scope.setProductFilter = function($index,fltr_cat){
		var arr = Array.prototype.slice.call( $scope.filter[fltr_cat]);
		var indx = arr.indexOf($scope[fltr_cat][$index]); 
		if ( indx=== -1)
			$scope.filter[fltr_cat].push( $scope[fltr_cat][$index]);
		else
			$scope.filter[fltr_cat].splice(indx,1);
			
		var fltrs_present = false;
		//init filtering, cancle existing hidden items
		for ( var prod in $scope.products){
			$scope.products[prod].hidden = false;
			$scope.products[prod].srch_rtng = 0;
		};
		$scope.products_filtered = $scope.products;
		
		for(var selbr in $scope.filter){
			for(var items in $scope.filter[selbr]){
				fltrs_present = true;
				for ( var prod in $scope.products){
					if($scope.products[prod][selbr] !== undefined && $scope.products[prod][selbr] === $scope.filter[selbr][items]){
						$scope.products[prod].srch_rtng++;
					}
				}
			}
		};
		
		//exit filtering,  hide items if rating is 0
		
		if(fltrs_present === true){
			$scope.products_filtered = [];
			for ( var prod in $scope.products ){
			
			if($scope.products[prod].srch_rtng === 0 ){
				$scope.products[prod].hidden = true;
			}
			else{
				$scope.products_filtered.push($scope.products[prod]);
			}
		 }
	};
	
	};
	
	
	$scope.isFiltered = function(product){
		if ($scope.brandFilter.indexOf(product.brand) !== -1)
			return true;
		return false;
	};
	
	$scope.checkIndex = function($index){
		if ($index % 3 == 0)
			return true;
		return false;
	};
	
	$scope.checkEndIndex = function($index){
		if ($index % 3 == 2)
			return true;
		return false;
	};
	
	$scope.price_low = 0;
	$scope.price_high = 0;
	
	$scope.filterByPrice = function(){
		for ( var prod in $scope.products_filtered){
			$scope.products_filtered[prod].hidden = false;
			if( ($scope.price_low !== 0 && $scope.products_filtered[prod].price <= $scope.price_low) || ($scope.price_high !== 0 && $scope.products_filtered[prod].price >= $scope.price_high) )
				$scope.products_filtered[prod].hidden = true;
		};
		
	};
	
	$scope.AddCompare = [];
	$scope.prev_prod_filtered = [];
	$scope.toggleAddCompare = function(product){
		var found = false;
		for(var item in $scope.AddCompare){
			if($scope.AddCompare[item].image_url == product.image_url){
				$scope.AddCompare.splice(item,1);
				found = true;
			}
		}
		if(found == false){
			$scope.AddCompare.push(product);
			$scope.prev_prod_filtered = $scope.products_filtered;
		}
		
		if($scope.AddCompare.length == 0)
			$scope.products_filtered = $scope.prev_prod_filtered;
	};
	
	$scope.navigateToCompare = function(){
		$scope.products_filtered = $scope.AddCompare;
	}


  });
