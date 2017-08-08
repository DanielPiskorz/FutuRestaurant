angular.module('app', []).controller('home', function ($scope, $http) {
	$http.get("/restaurant")
	.then(function(response) {
        $scope.restaurants = response.data;
    });
});