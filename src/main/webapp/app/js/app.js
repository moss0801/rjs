(function(define) {
  define([
    'angular',
    'js/routes',
    'text!messageList',
    // directvie
    'js/directives/rjsInput',
    'js/directives/rjsDynamicColumn',
    'js/directives/rjsScroller',
    'js/directives/ticketTable',
    'js/directives/rjsAccept',
    'js/directives/rjsFile',
    'js/directives/rjsFileSize',
    // service
    'js/services/baseService',
    'js/services/ticketService',
    // controller
    'js/controllers/baseController',
    'js/controllers/slyController',
    'js/controllers/scrollController',
    'js/controllers/dynamicColumnController',
    'js/controllers/ticketTableController',
    'js/controllers/tinymceController',
    'js/controllers/manyTabController',
    'js/controllers/validController'
  ], function(angular, routes, messageList,
      rjsInputDirective, rjsDynamicColumnDirective, rjsScrollerDirective, ticketTableDirective, rjsAcceptDirective, rjsFileDirective, rjsFileSizeDirective,
      baseService, ticketService,
      baseController, slyController, scrollController, dynamicColumnController, ticketTableController, tinymceController, manyTabController, validController) {
    var app = angular.module('app', ['ngResource', 'ngCookies', 'ui.router', 'pascalprecht.translate', 'infinite-scroll', 'ui.bootstrap', 'ui.tinymce'])
      .config(routes)
      .config(function ($translateProvider) {
        $translateProvider.translations('en', angular.fromJson(messageList));
        $translateProvider.preferredLanguage('en');
      })
      .directive('rjsInput', rjsInputDirective)
      .directive('rjsDynamicColumn', rjsDynamicColumnDirective)
      .directive('rjsScroller', rjsScrollerDirective)
      .directive('ticketTable', ticketTableDirective)
      .directive('rjsAccept', rjsAcceptDirective)
      .directive('rjsFile', rjsFileDirective)
      .directive('rjsFileSize', rjsFileSizeDirective)
      .service('baseService', baseService)
      .service('ticketService', ticketService)
      .controller('baseController', baseController)
      .controller('slyController', slyController)
      .controller('scrollController', scrollController)
      .controller('dynamicColumnController', dynamicColumnController)
      .controller('ticketTableController', ticketTableController)
      .controller('tinymceController', tinymceController)
      .controller('manyTabController', manyTabController)
      .controller('validController', validController)
      .value('test', 'test')
      
      ;
    
    return app;
  });
})(define);