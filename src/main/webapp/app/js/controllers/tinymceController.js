(function(define) {
  'use strict';
  define([], function() {
    return ['$scope',
      function($scope) {
        $scope.tinymceOptions = {
          resize: false,
          width: 400,  // I *think* its a number and not '400' string
          height: 300,
          plugins: 'print textcolor',
          toolbar: "undo redo styleselect bold italic print forecolor backcolor"
        };
        
        $scope.tinymceModel = {
            one: "test"
        };
    }];
  });
})(define);