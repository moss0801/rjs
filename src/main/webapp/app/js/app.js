(function(define) {
  define([
    'angular',
    'js/routes',
    'text!messageList',
    // directvie
    'js/directives/rjsInput',
    'js/directives/rjsDynamicColumn',
    'js/directives/rjsScroller',
    // service
    'js/services/baseService',
    // controller
    'js/controllers/baseController',
    'js/controllers/slyController',
    'js/controllers/scrollController',
    'js/controllers/dynamicColumnController',
    'angular-ui-router',
  ], function(angular, routes, messageList,
      rjsInputDirective, rjsDynamicColumnDirective, rjsScrollerDirective,
      baseService,
      baseController, slyController, scrollController, dynamicColumnController) {
    var app = angular.module('app', ['ngResource', 'ngCookies', 'ui.router', 'pascalprecht.translate', 'infinite-scroll'])
      .config(routes)
      .config(function ($translateProvider) {
        $translateProvider.translations('en', angular.fromJson(messageList));
        $translateProvider.preferredLanguage('en');
      })
      .directive('rjsInput', rjsInputDirective)
      .directive('rjsDynamicColumn', rjsDynamicColumnDirective)
      .directive('rjsScroller', rjsScrollerDirective)
      .service('baseService', baseService)
      .controller('baseController', baseController)
      .controller('slyController', slyController)
      .controller('scrollController', scrollController)
      .controller('dynamicColumnController', dynamicColumnController)
      .value('test', 'test')
      
      ;
    
    return app;
  });
})(define);