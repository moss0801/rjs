(function(define) {
  'use strict';
  define([], function() {
    return ['$scope',
      function($scope) {
        $scope.tinymceOptions = {
          handle_event_callback: function (e) {
          // put logic here for keypress
          }
        };
    }];
  });
})(define);