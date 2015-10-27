'use strict';

angular.module('myDocumentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('admin', {
          url: baseURL + '/admin',
          templateUrl: baseURL + '/admin/admin.html',
          controller: 'AdminCtrl'
      });
});