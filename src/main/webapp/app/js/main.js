'use strict';

require.config({
  baseUrl: 'app',
  paths: {
    'text': '../bower_components/requirejs-text/text',
    'angular': '../bower_components/angular/angular',
    'angular-i18n': 'i18n/angular-locale_' + appProperties.jsLocale,
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
    'angular-i18n': {
      deps: ['angular']
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
    }
  }
});

// bootstarp angular
require([
         'text',
         'angular',
         'js/app',
         'angular-i18n',
         'angular-resource',
         'angular-cookies',
         'angular-ui-router',
         'angular-translate'], function (text, angular, app) {
  angular.bootstrap(document, ['app']);
});