(function(define) {
  'use strict';
  define(['tinymce'], function(tinymce) {
    return ['$scope',
      function($scope) {
        var count = 1;
        $scope.tabList = [];
        $scope.tabList.push({
          title: 'title' + count,
          tootle: 'tooltip' + count,
          content: 'content' + count + 'content' + count + 'content' + count + 'content' + count          
        });
        
        var list = [];
        for (var i = 1; i < 200; i++) {
          count++;
          list.push({
            title: 'title' + count,
            tootle: 'tooltip' + count,
            content: 'content' + count + 'content' + count + 'content' + count + 'content' + count          
          });
        }
        $scope.tabList = list;
        
        $scope.addTab = function() {
          count++;
          $scope.tabList.push({
            title: 'title' + count,
            tootle: 'tooltip' + count,
            content: 'content' + count + 'content' + count + 'content' + count + 'content' + count          
          });
        };
      
    }];
  });
})(define);