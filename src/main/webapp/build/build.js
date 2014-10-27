({
  baseUrl : "../app",
  paths: {
    'requirejs': '../bower_components/requirejs/require',
    'text': '../bower_components/requirejs-text/text',
    'angular': '../bower_components/angular/angular.min',
    'angular-resource': '../bower_components/angular-resource/angular-resource.min',
    'angular-cookies': '../bower_components/angular-cookies/angular-cookies.min',
    'angular-ui-router': '../bower_components/angular-ui-router/release/angular-ui-router.min',
    'angular-translate': '../bower_components/angular-translate/angular-translate.min',
    'angular-translate-loader-static-files': '../bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files.min'
  },
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
  },
  name: "js/main",
  include: 'requirejs',
  out: '../dist/main.js',
  removeCombined: true,
  optimize: 'uglify2',
  uglify2: {
    mangle: false
  },
  preserveLicenseComments: false
})