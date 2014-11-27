(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', 'ticketService',
      function($scope, ticketService) {
        $scope.ticketList = ticketService.list();
        // do something
        
        $scope.ticketColumnList = ['Subject', 'Subject', 'No'];
    }];
  });
})(define);