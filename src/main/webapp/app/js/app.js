(function(define) {
  define([
    'angular',
    'js/controllers/baseController'
  ], function(angular, baseController) {
    var app = angular.module('app', [])
      .controller('baseController', baseController)
      .value('test', 'test');
    
    angular.bootstrap(document, ['app']);
    
    return app;
  });
})(define);