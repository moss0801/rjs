(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return ['$compile', '$templateCache', '$http', '$log',
      function($compile, $templateCache, $http, $log) {
        return {
          restrict: 'A',
          priority: 1001,
          templateUrl: 'app/templates/rjsDynamicColumn.html',
          compile: function compile(element, attrs, transclude) {
            return {
              pre: function preLink(scope, element, attrs, controller) {
                scope.columnList = scope.$eval(attrs.columnList);
                
                scope.alert = function(value) {
                  alert(value);
                };
                
                var template = $templateCache.get('app/templates/rjsDynamicColumn.html');
                var templateElement = angular.element(template[1]);
                
                // template 구성
                element.html('');
                for (var i = 0; i < scope.columnList.length; i++) {
                  for (var j = 0; j < templateElement.length; j += 2) {
                    var target = angular.element(templateElement[j]);
                    if (scope.columnList[i] === target.attr('column-name')) {
                      target.removeAttr('column-name');
                      
                      element.append(target);
                      element.addClass(scope.columnList[i]);
                      break;
                    }
                  }
                }
                
                attrs.$set('rjsDynamicColumn', undefined);
                $compile(element)(scope);
              },
              post: function postLink(scope, element, attrs, controller) {

              }
            };
          },
          terminal: true
        };
    }];
  });
})(define);