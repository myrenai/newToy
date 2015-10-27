'use strict';

angular.module('myDocumentManagerApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('menu1', {
          url: baseURL + '/resources/menu1',
          templateUrl: baseURL + '/resources/menu1/menu1.html',
          controller: 'Menu1Ctrl'
      });
});