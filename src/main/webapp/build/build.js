({
  baseUrl : "../app",
  paths: {
    'text': '../bower_components/requirejs-text/text',
    'angular': '../bower_components/angular/angular',
    'angular-ui-router': '../bower_components/angular-ui-router/release/angular-ui-router'
  },
  shim: {
    'angular': {
      exports: 'angular'
    },
    'angular-ui-router': {
      deps: ['angular']
    }
  },
  name: "js/main",
  out: "../dist/main.js",
  removeCombined: true
})