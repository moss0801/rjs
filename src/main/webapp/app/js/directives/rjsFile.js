(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return [function() {
      return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs, ctrl){
          element.on('change', function() {
            scope.$apply(function() {
              ctrl.$setViewValue(element[0].files[0]);
            });
          });
        }
      };
    }];
  });
})(define);