'use strict';

angular.module('myDocumentManagerApp')
  .controller('MainCtrl', function ($scope, $http) {

    $scope.baseURL = baseURL;
    $scope.navbarURL = baseURL + '/resources/navbar/navbar.html';
    console.log($scope.baseURL)
    
    

});