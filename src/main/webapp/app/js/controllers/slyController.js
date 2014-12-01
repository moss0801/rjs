(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', 'baseService',
      function($scope, baseService) {
        $scope.bookList = baseService.list();
        
        $scope.reload = function() {
          $scope.bookList = baseService.list();
        };
        
        $scope.onTitleClick = function(item) {
          if (item.$clicked) {
            item.$clicked = false;
          } else {
            angular.forEach($scope.bookList, function(book) {
              if (item !== book)
                book.$clicked = false;
            });
            item.$clicked = true;
          }
        };
    }];
  });
})(define);