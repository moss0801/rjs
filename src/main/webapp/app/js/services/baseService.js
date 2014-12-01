(function(define) {
  'use strict';
  define([], function() {
    return ['$resource', function($resource) {
      return $resource('book/:bookId', {}, {
        get: {method: 'GET'},
        list: {method: 'GET', isArray : true}
      });
    }];
  });
})(define);