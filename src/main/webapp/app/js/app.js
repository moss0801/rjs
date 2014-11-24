(function(define) {
  define([
    'angular',
    'js/routes',
    'text!messageList',
    // directvie
    'js/directives/rjsInput',
    'js/directives/rjsScroller',
    // service
    'js/services/baseService',
    // controller
    'js/controllers/baseController',
    'js/controllers/slyController',
    'js/controllers/scrollController',
    'angular-ui-router',
  ], function(angular, routes, messageList,
      rjsInputDirective, rjsScrollerDirective,
      baseService,
      baseController, slyController, scrollController) {
    var app = angular.module('app', ['ngResource', 'ngCookies', 'ui.router', 'pascalprecht.translate', 'infinite-scroll'])
      .config(routes)
      .config(function ($translateProvider) {
        $translateProvider.translations('en', angular.fromJson(messageList));
        $translateProvider.preferredLanguage('en');
      })
      .directive('rjsInput', rjsInputDirective)
      .directive('rjsScroller', rjsScrollerDirective)
      .service('baseService', baseService)
      .controller('baseController', baseController)
      .controller('slyController', slyController)
      .controller('scrollController', scrollController)
      .value('test', 'test')
      
      ;
    
    return app;
  });
})(define);