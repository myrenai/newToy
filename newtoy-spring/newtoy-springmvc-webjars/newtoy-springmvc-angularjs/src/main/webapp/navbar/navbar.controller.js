'use strict';

angular.module('myDocumentManagerApp')
  .controller('NavbarCtrl', function ($scope, $http, $location) {

	console.log($location.path());
    $scope.menus = [{"label" : "menu1","link" : baseURL + "/menu1"}];
    $scope.adminItems = [{"label" : "user account","link" : baseURL + "/admin/account"}];
    
    $scope.isActive = function(route) {
      return baseURL + '/' + route === $location.path();
    };
    
    


  });