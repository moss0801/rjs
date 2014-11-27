(function(define) {
  'use strict';
  define([], function() {
    return ['$resource', function($resource) {
      return $resource('api/ticket/:ticketNo', {}, {
        get: {method: 'GET'},
        list: {method: 'GET', isArray : true}
      });
    }];
  });
})(define);