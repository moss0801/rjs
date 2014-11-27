(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return ['$interpolate', '$log', function($interpolate, $log) {
      return {
        restrict: 'E',
        template: '<div ng-include="tableTemplateUrl"></div>',
        scope: {
          ticketList: '=',
          columnList: '='
        },
        link: function(scope, element, attrs, ctrl){
          var baseTemplateUrl = 'app/templates/directives/ticketTable.html';
          // 
          
          // column list에 따라 temlate 변경
          scope.$watch('columnList', function(columnList) {
            var templateUrl = angular.copy(baseTemplateUrl);
            templateUrl += "?";
            if (columnList !== undefined && columnList !== null) {
              for (var i = 0; i < columnList.length; i++) {
                templateUrl += "columnList=" + columnList[i] + "&";
              }
            }
            
            scope.tableTemplateUrl = templateUrl;
          });
        }
      };
    }];
  });
})(define);