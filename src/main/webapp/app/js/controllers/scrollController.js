(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', 'baseService',
      function($scope, baseService) {
        $scope.list = [];
        $scope.busy = false;
        
        $scope.nextPage = function() {
          if ($scope.busy) return;
          $scope.busy = true;
          baseService.list({}, function(result) {
            $scope.list = $scope.list.concat(result);
            $scope.busy = false;
          });
        };
    }];
  });
})(define);