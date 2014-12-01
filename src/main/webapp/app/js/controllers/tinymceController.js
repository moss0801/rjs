(function(define) {
  'use strict';
  define(['tinymce'], function(tinymce) {
    return ['$scope',
      function($scope) {
        $scope.readonly = false;
        $scope.editor;
        $scope.showEditor = true;
        
        $scope.toggleReadonly = function() {
          $scope.tinymceOptions.readonly = !$scope.tinymceOptions.readonly;
        };
        
        $scope.toggleEditor = function() {
          $scope.showEditor = !$scope.showEditor;
        };
        
      
        $scope.tinymceOptions = {
          readonly: $scope.readonly,
          init_instance_callback : function(editor) {
            $scope.editor = tinymce.get(editor.id);
          }
        };
        
        // $scope의 변수를 바로 바인딩하면 two-way binding이 먹지 않음
        $scope.tinymceModel = {
            one: 'test<br />test'
        }
    }];
  });
})(define);