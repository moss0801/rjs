'use strict';

require.config({
  baseUrl: 'app',
  paths: {
    'angular': '../bower_components/angular/angular'
  },
  //angular does not support AMD out of the box, put it in a shim
  shim: {
    'angular': {
      exports: 'angular'
    }
  },
  deps: ['js/app']
});