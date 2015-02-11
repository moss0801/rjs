(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return [function() {
      return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs, ctrl){
          function endsWith(str, suffix) {
            return str.indexOf(suffix, str.length - suffix.length) !== -1;
          }
          var name = 'rjsAccept';
          var acceptList = attrs.rjsAccept.match(/(?=\S)[^,]+?(?=\s*(,|$))/g);
          var validTest = function(value) {
            if (value === undefined || value === null || value.name === undefined || value.name === null) {
              return true;
            }
            for (var i = 0; i < acceptList.length; i++) {
              if (endsWith(value.name, acceptList[i])) {
                return true;
              }
            }
            return false;
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