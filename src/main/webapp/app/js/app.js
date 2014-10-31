(function(define) {
  define([
    'angular',
    'js/routes',
    'text!messageList',
    // directvie
    'js/directives/rjsScroller',
    // service
    'js/services/baseService',
    // controller
    'js/controllers/baseController',
    'angular-ui-router',
  ], function(angular, routes, messageList,
      rjsScrollerDirective,
      baseService,
      baseController) {
    var app = angular.module('app', ['ngResource', 'ngCookies', 'ui.router', 'pascalprecht.translate'])
      .config(routes)
      .config(function ($translateProvider) {
        $translateProvider.translations('en', angular.fromJson(messageList));
        $translateProvider.preferredLanguage('en');
      })
      .directive('rjsScroller', rjsScrollerDirective)
      .service('baseService', baseService)
      .controller('baseController', baseController)
      .value('test', 'test')
      
      ;
    
    return app;
  });
})(define);