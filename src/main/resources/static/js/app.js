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

	  const formData = new FormData();
      const file = $scope.photo;
      $scope.newRestaurant.photoExtension = file.name.substring(file.name.lastIndexOf('.'));
      const json = $scope.newRestaurant;
      console.log(file.name)
      formData.append("file", file);
      formData.append("restaurant",JSON.stringify(json));
      const req = {
        url: '/owner/restaurant',
        method: 'POST',
        headers: {'Content-Type': undefined},
        data: formData,
        transformRequest: angular.identity
        }
      $http(req);
	}

       
})
.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

