'use strict';

require.config({
  baseUrl: 'app',
  paths: {
    'text': '../bower_components/requirejs-text/text',
    'angular': '../bower_components/angular/angular',
    'angular-i18n_en-us': 'i18n/angular-locale_en-us',
    'angular-i18n_ko-kr': 'i18n/angular-locale_ko-kr',
    'angular-i18n_ko': 'i18n/angular-locale_ko',
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
    'angular-i18n_en-us': {
      deps: ['angular']
    },
    'angular-i18n_ko-kr': {
      deps: ['angular']
    },
    'angular-i18n_ko': {
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
         'angular-resource',
         'angular-cookies',
         'angular-ui-router',
         'angular-translate'], function (text, angular, app) {
  angular.bootstrap(document, ['app']);
});

// i18n 설정
if ('ko' === appProperties.jsLocale) {
  require(['angular-i18n_ko'], function(i18n) {});
} else if ('ko_KR' === appProperties.jsLocale) {
  require(['angular-i18n_ko-kr'], function(i18n) {});
} else if ('en-us' === appProperties.jsLocale) {
  require(['angular-i18n_en-us'], function(i18n) {});
}