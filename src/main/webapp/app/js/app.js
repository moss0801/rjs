(function(define) {
  define([
    'angular',
    'js/routes',
    'js/controllers/baseController',
    'angular-ui-router',
  ], function(angular, routes, baseController) {
    var app = angular.module('app', ['ui.router'])
      .config(routes)
      .controller('baseController', baseController)
      .value('test', 'test');
    
    return app;
  });
})(define);