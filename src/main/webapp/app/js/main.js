'use strict';

require.config({
  baseUrl: 'app',
  paths: {
    'text': '../bower_components/requirejs-text/text',
    'jquery': '../bower_components/jquery/dist/jquery.min',
    'angular': '../bower_components/angular/angular',
    'angular-i18n_en-us': 'i18n/angular-locale_en-us',
    'angular-i18n_ko-kr': 'i18n/angular-locale_ko-kr',
    'angular-i18n_ko': 'i18n/angular-locale_ko',
    'angular-resource': '../bower_components/angular-resource/angular-resource',
    'angular-cookies': '../bower_components/angular-cookies/angular-cookies',
    'angular-ui-router': '../bower_components/angular-ui-router/release/angular-ui-router',
    'angular-translate': '../bower_components/angular-translate/angular-translate',
    'angular-translate-loader-static-files': '../bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files',
    'angular-boostrap': '../bower_components/angular-bootstrap/ui-bootstrap-tpls.min',
    'ngInfiniteScroll': '../bower_components/ngInfiniteScroll/build/ng-infinite-scroll.min',
    'messageList' : '../message/' + appProperties.locale + ".json",
    'tinymce': '../bower_components/tinymce/tinymce.min',
    'angular-ui-tinymce': '../bower_components/angular-ui-tinymce/src/tinymce'
  },
  //angular does not support AMD out of the box, put it in a shim
  shim: {
    'jquery': {
      exports: 'jquery'
    },
    'angular': {
      exports: 'angular',
      deps: ['tinymce']
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
    },
    'ngInfiniteScroll': {
      deps: ['angular', 'jquery']
    },
    'tinymce': {
      exports: 'tinymce'
    },
    'angular-boostrap': {
      deps: ['angular']
    },
    'angular-ui-tinymce': {
      deps: ['angular', 'tinymce', 'angular-boostrap']
    }
  }
});

// bootstarp angular
require([
         'text',
         'jquery',
         'angular',
         'js/app',
         'tinymce',
         'angular-resource',
         'angular-cookies',
         'angular-ui-router',
         'angular-translate',
         'ngInfiniteScroll',
         'angular-ui-tinymce'], function (text, $, angular, app, tinymce) {
  //i18n 설정
  if ('ko' === appProperties.jsLocale) {
    require(['angular-i18n_ko'], function(i18n) {
      angular.bootstrap(document, ['app']);
    });
  } else if ('ko_KR' === appProperties.jsLocale) {
    require(['angular-i18n_ko-kr'], function(i18n) {
      angular.bootstrap(document, ['app']);
    });
  } else if ('en-us' === appProperties.jsLocale) {
    require(['angular-i18n_en-us'], function(i18n) {
      angular.bootstrap(document, ['app']);
    });
  }
  
});

