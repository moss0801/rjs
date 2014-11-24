(function(define) {
  'use strict';
  define([], function() {
    return ['$resource', function($resource) {
      return $resource('book', {}, {
        list: {method: 'GET', isArray: true}
      });
    }];
  });
})(define);