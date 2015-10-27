'use strict';

angular.module('myDocumentManagerApp')
  .controller('MainCtrl', function ($scope, $http, $rootScope) {
	  
	$rootScope.baseURL = baseURL;
	$rootScope.navbarURL = baseURL + '/navbar/navbar.html';
	

});