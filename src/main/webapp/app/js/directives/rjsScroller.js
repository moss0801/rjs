(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return ['$timeout', '$log', function($timeout, $log) {
      return {
        restrict: 'A',
        link: function(scope, element, attrs, ctrl){
          scope.$watch(function() {
            return scope.$eval("bookList.length");
          }, function(newLength) {
            $log.debug(newLength);
            if (newLength === 0) {
              return ;
            }
            // 목록 재 로드시 scroller reload 및 top으로 이동
            $timeout(function() {
              $log.debug('reload and slideTo(0)');
            }, 300);
            
            
            var titleList = element.find("h3");
            var bookList = scope.$eval('bookList');
            $log.debug(titleList);
            for (var i = 0; i< titleList.length; i++) {
              var titleElement = angular.element(titleList[i]);
              titleElement.attr('index', i);
              titleElement.on('click', function(e) {
                var index = parseInt(angular.element(e.target).attr('index'), 10);
                var $clicked = bookList[index].$clicked;
                if ($clicked) {
                  $timeout(function() {
                    $log.debug('reload and slideTo(e.target)')
                  }, 300);
                } else {
                  var isAllClosed = true;
                  // 모두 다 닫혔는지 확인
                  for (var i = 0; i < bookList.length; i++) {
                    if (true === bookList[i].$clicked) {
                      isAllClosed = false;
                      break;
                    }
                  }
                  
                  // 모두 다 닫힌경우 reload 후 top으로 열린게 있다면 열리는 쪽에서 reload 처리됨
                  if (isAllClosed) {
                    $timeout(function() {
                      $log.debug('all closed, reload and toTop')
                    }, 300);
                  }
                }
                $log.debug(index);
                $log.debug(bookList[index].$clicked);
              });
              
              /*scope.$watch(function() {

                return scope.$eval('bookList')[i].$clicked;
              }, function(newValue, oldValue) {
                $log.debug(newValue + ', ' + oldValue);
              });
              $log.debug(titleElement);*/
            }
          });
        }
      };
    }];
  });
})(define);