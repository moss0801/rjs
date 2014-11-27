(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', 'ticketService',
      function($scope, ticketService) {
        $scope.ticketList = ticketService.list();
        
        $scope.ticketColumnList = [];
        
        $scope.firstColumn = function() {
          $scope.ticketColumnList = ['No', 'CreateDate', 'Subject'];
        };
        
        $scope.secondColumn = function() {
          $scope.ticketColumnList = ['No', 'Subject', 'CreateDate'];
        };
    }];
  });
})(define);