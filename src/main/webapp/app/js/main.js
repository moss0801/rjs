'use strict';

require.config({
  baseUrl: 'app',
  paths: {
    'text': '../bower_components/requirejs-text/text',
    'angular': '../bower_components/angular/angular',
    'angular-ui-router': '../bower_components/angular-ui-router/release/angular-ui-router'
  },
  //angular does not support AMD out of the box, put it in a shim
  shim: {
    'angular': {
      exports: 'angular'
    },
    'angular-ui-router': {
      deps: ['angular']
    }
  }
});

// bootstarp angular
require(['text', 'angular', 'js/app'], function (text, angular, app) {
  angular.bootstrap(document, ['app']);
});