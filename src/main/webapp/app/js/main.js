'use strict';

require.config({
  baseUrl: 'app',
  paths: {
    'text': '../bower_components/requirejs-text/text',
    'angular': '../bower_components/angular/angular',
    'angular-resource': '../bower_components/angular-resource/angular-resource',
    'angular-cookies': '../bower_components/angular-cookies/angular-cookies',
    'angular-ui-router': '../bower_components/angular-ui-router/release/angular-ui-router',
    'angular-translate': '../bower_components/angular-translate/angular-translate',
    'angular-translate-loader-static-files': '../bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files',
    'messageList' : '../message/' + appProperties.locale + ".json"
  },
  //angular does not support AMD out of the box, put it in a shim
  shim: {
    'angular': {
      exports: 'angular'
    },
    'angular-resource': {
      deps: ['angular']
    },
    'angular-cookies': {
      deps: ['angular']
    },
    'angular-ui-router': {
      deps: ['angular']
    },
    'angular-translate': {
      deps: ['angular']
    },
    'angular-translate-loader-static-files': {
      deps: ['angular-translate']
    }
  }
});

// bootstarp angular
require([
         'text',
         'angular',
         'js/app',
         'angular-resource',
         'angular-cookies',
         'angular-ui-router',
         'angular-translate',
         'angular-translate-loader-static-files'], function (text, angular, app) {
  angular.bootstrap(document, ['app']);
});