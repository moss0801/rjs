(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return ['$compile', '$templateCache', '$http', '$log',
      function($compile, $templateCache, $http, $log) {
        var templateUrl = 'app/templates/rjsDynamicColumn.html';
        var columnNameAttrName = 'column-name';
        return {
          restrict: 'A',
          priority: 1001,
          templateUrl: templateUrl,
          compile: function compile(element, attrs, transclude) {
            return {
              pre: function preLink(scope, element, attrs, controller) {
                scope.columnList = scope.$eval(attrs.columnList);
                
                scope.alert = function(value) {
                  alert(value);
                };
                
                // compile time에 template을 로드할 수 있도록 templateUrl에 지정 후, 다시 로드
                var template = $templateCache.get(templateUrl);
                var templateElement = angular.element(template[1]);
                // 기존 template 제거
                element.html('');
                
                // template 구성
                for (var i = 0; i < scope.columnList.length; i++) {
                  for (var j = 0; j < templateElement.length; j += 2) {
                    var target = angular.element(templateElement[j]);
                    if (scope.columnList[i] === target.attr(columnNameAttrName)) {
                      target.removeAttr(columnNameAttrName);
                      
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