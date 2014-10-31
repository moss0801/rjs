(function(define) {
  'use strict';
  define([], function() {
    return ['$resource', function($resource) {
      return $resource('book', {}, {
        get: {method: 'GET', isArray: true}
      });
    }];
  });
})(define);