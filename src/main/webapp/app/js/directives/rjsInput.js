(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return ['$interpolate', '$log', function($interpolate, $log) {
      return {
        restrict: 'A',
        link: function(scope, element, attrs, ctrl){
          element.on('keyup', function(e) {
            // enter
            if (13 === e.keyCode) {
              scope.$apply(function() {
                $interpolate('{{' + attrs.rjsInput + '}}')(scope);
              });
              e.stopPropagation();
            }
          });
          
          element.on('focusin', function(e) {
            $log.debug('focusin');
          });
          
          element.on('focusout', function(e) {
            $log.debug('focusout');
          });
        }
      };
    }];
  });
})(define);