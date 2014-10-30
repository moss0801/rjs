(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', '$cookies', '$location', 'baseService',
      function($scope, $cookies, $location, baseService) {
        $scope.test = "aaaaa";
        $cookies.test = "test";
        $scope.nameList = baseService.get();
        $scope.now = new Date();
        
        $scope.toEee = function() {
          
        };
    }];
  });
})(define);