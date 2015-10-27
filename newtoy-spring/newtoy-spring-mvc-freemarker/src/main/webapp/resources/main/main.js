'use strict';

angular.module('myDocumentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('main', {
        url: baseURL + '/',
        templateUrl: baseURL + '/resources/main/main.html',
        controller: 'MainCtrl'
      });
});
