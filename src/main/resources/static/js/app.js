angular.module('app', ['ngRoute'])

.config(['$routeProvider', '$locationProvider',
	  function($routeProvider, $locationProvider) {
   $routeProvider
    .when("/", {
        templateUrl : "home.html",
    })
    .when("/restaurant", {
        templateUrl : "restaurant.html",
    })
    .otherwise({
        template : "This page doesn't exist."
    });
   $locationProvider.html5Mode({
	   enabled: true,
	   requireBase: false
	 });
}])
.controller('home', function ($scope, $rootScope, $http) {
	$http.get("/restaurants")
	.then(function(response) {
        $scope.restaurants = response.data;
        $scope.setId= function(id){
        	$rootScope.id = id;
        }
    });
});