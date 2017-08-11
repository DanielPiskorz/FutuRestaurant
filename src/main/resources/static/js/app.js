angular.module('app', ['ngRoute'])

.config(['$routeProvider', '$locationProvider',
	  function($routeProvider, $locationProvider) {
   $routeProvider
    .when("/", {
        templateUrl : "home.html",
    })
    .when("/restaurant/:restaurantId", {
        templateUrl : "restaurant.html",
    })
    .otherwise({
        template : "This page doesn't exist."
    });

}])
.controller('home', function ($scope, $rootScope, $http, $routeParams) {
	$http.get("/restaurants")
	.then(function(response) {
        $scope.restaurants = response.data;
        const id = $routeParams.restaurantId;
        
        $scope.restaurants.forEach(function (item) {
        	if(item.id == id)
        		$rootScope.selectedRestaurant = item;
        });
        
        $scope.setRestaurant = function(r){
        	$rootScope.selectedRestaurant = r;
        }
    });
});