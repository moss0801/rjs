(function(define) {
  'use strict';
  define([], function() {
    return ['$scope', '$cookies', 'baseService',
      function($scope, $cookies, baseService) {
        $scope.test = "aaaaa";
        $cookies.test = "test";
        $scope.name = baseService.get();
    }];
  });
})(define);