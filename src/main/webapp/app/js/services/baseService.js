(function(define) {
  'use strict';
  define([], function() {
    return ['$resource', function($resource) {
      return $resource('name', {}, {
        get: {method: 'GET', isArray: true}
      });
    }];
  });
})(define);