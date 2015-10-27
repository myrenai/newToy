'use strict';

angular.module('myDocumentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('main', {
        url: baseURL + '/',
        templateUrl: baseURL + '/main/main.html',
        controller: 'MainCtrl'
      });
});
