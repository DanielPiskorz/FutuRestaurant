angular.module('app', ['ngRoute'])

.config(['$routeProvider', '$locationProvider',
	  function($routeProvider, $locationProvider) {
   $routeProvider
    .when("/", {
        templateUrl : "pages/home.html",
    })
    .when("/restaurant/:restaurantId", {
        templateUrl : "pages/restaurant.html",
    })
    .when("/new-restaurant", {
        templateUrl : "pages/newRestaurantForm.html",
        controller: "newRestaurantCtrl"
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
})
.controller('newRestaurantCtrl', function ($scope, $rootScope, $http) {
	
    $scope.submit = function(){
        $http.post('/owner/restaurant', $scope.newRestaurant)
        .then(
        function success() {
            $scope.result = "SUCCESS";
        }
        ,function error(){
            $scope.result = "ERROR";
        });
    };
});