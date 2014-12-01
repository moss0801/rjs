(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', '$cookies', '$location', 
      function($scope, $cookies, $location) {
        /*$scope.test = "aaaaa";
        $cookies.test = "test";
        $scope.bookList = baseService.get();
        $scope.now = new Date();
        
        $scope.reload = function() {
          $scope.bookList = baseService.get();
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
        
        $scope.addTest = function(input) {
          $scope.test += input; 
        };*/
    }];
  });
})(define);