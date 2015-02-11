(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return [function() {
      return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs, ctrl){
          var name = 'rjsFileSize';
          var limitSize = attrs.rjsFileSize * 1;
          var validTest = function(value) {
            if (value === undefined || value === null || value.size === undefined || value.size === null) {
              return true;
            }
            if (value.size > limitSize) {
              return false;
            }
            return true;
          };
          
          ctrl.$parsers.unshift(function(value) {
            var valid = validTest(value);
            ctrl.$setValidity(name, valid);
            
            return valid ? value : undefined;
          });
          
          ctrl.$formatters.unshift(function(value) {
            var valid = validTest(value);
            ctrl.$setValidity(name, valid);
            
            return value;
          });
        }
      };
    }];
  });
})(define);