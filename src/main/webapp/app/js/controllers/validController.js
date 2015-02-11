(function(define) {
  'use strict';
  define([], function() {
    return ['$scope',
      function($scope) {
        $scope.model = {
            fileName: null,
            attachFile: {
              name: 'test.jpg',
              size: 123534,
              type: 'image/png'
            }
        };
        $scope.model.attachFile = null;
    }];
  });
})(define);