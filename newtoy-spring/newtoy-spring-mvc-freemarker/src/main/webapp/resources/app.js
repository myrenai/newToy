'use strict';

angular.module('myDocumentManagerApp', [
  'ui.router',
  'ui.bootstrap'
])
  .config(function ($stateProvider, $urlRouterProvider, $locationProvider) {
    $urlRouterProvider
      .otherwise(baseURL);

    $locationProvider.html5Mode(true);
  });