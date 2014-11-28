(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', 'ticketService',
      function($scope, ticketService) {
        var baseTemplateUrl = 'app/templates/directives/ticketTable.html';
        $scope.ticketList = ticketService.list();
        
        $scope.ticketColumnList = ['No', 'Important', 'Service', 'InquiryType', 'Channel', 'Subject', 'CreateDate', 'Assignee', 'SolveDate'];
        
        $scope.firstColumn = function() {
          $scope.ticketColumnList = ['No', 'Important', 'CreateDate', 'Subject'];
        };
        
        $scope.secondColumn = function() {
          $scope.ticketColumnList = ['No', 'Important', 'Subject', 'CreateDate'];
        };
        
        $scope.busy = false;
        
        $scope.nextPage = function() {
          if ($scope.busy) return;
          $scope.busy = true;
          ticketService.list({}, function(result) {
            $scope.ticketList = $scope.ticketList.concat(result);
            $scope.busy = false;
          });
        };
        
        //$scope.viewTemplateurl = 'app/templates/directives/ticketTable.html?columnList=No&columnList=Important&columnList=CreateDate&columnList=Subject';
        
        $scope.$watch('ticketColumnList', function(columnList) {
          var templateUrl = angular.copy(baseTemplateUrl);
          templateUrl += "?";
          if (columnList !== undefined && columnList !== null) {
            for (var i = 0; i < columnList.length; i++) {
              templateUrl += "columnList=" + columnList[i] + "&";
            }
          }
          
          $scope.viewTemplateurl = templateUrl;
        });
    }];
  });
})(define);