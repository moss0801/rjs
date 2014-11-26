(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', 'baseService',
      function($scope, baseService) {
        $scope.bookList = baseService.list();
        
        $scope.columnList = ['Title', 'PublishDate', 'Content', 'Price', 'ISBN', 'SalePrice', 'Page', 'Weight', 'SalePoint'];
        
        $scope.busy = false;
        
        $scope.nextPage = function() {
          if ($scope.busy) return;
          $scope.busy = true;
          baseService.list({}, function(result) {
            $scope.bookList = $scope.bookList.concat(result);
            $scope.busy = false;
          });
        };
    }];
  });
})(define);