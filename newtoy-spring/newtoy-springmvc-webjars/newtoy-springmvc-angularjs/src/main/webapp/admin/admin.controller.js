'use strict';

angular.module('myDocumentManagerApp')
  .controller('AdminCtrl', function($scope, $http) {

	$scope.allUsers = [];
	function getAllUsers($http, $scope) {
		$http.get(baseURL + '/spring/getAllUsers').success(
				function(rtnData) {
					$scope.allUsers.push(rtnData);
				});
	}

});