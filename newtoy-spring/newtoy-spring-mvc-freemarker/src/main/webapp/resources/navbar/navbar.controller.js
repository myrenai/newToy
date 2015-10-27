'use strict';

angular.module('myDocumentManagerApp')
  .controller('NavbarCtrl', function ($scope, $http, $location) {

	console.log($location.path());
	  
    $scope.menus = [
        {
        	"label" : "menu1",
        	"link" : baseURL + "/resources/menu1"
        }];
    
    $scope.isActive = function(route) {
      return '/docs/' + route === $location.path();
    };
    
    //////////////////////////////////////////////

    $scope.docRoots = [];


  });