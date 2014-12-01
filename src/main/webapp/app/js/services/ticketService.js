(function(define) {
  'use strict';
  define([], function() {
    return ['$resource', function($resource) {
      return $resource('api/ticket', {}, {
        get: {method: 'GET'},
        list: {method: 'GET', isArray : true}
      });
    }];
  });
})(define);