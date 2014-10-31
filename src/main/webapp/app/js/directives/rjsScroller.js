(function(define) {
  'use strict';
  define(['angular'], function(angular) {
    return ['$timeout', '$log', function($timeout, $log) {
      return {
        restrict: 'A',
        link: function(scope, element, attrs, ctrl){
          var properties = {
            list: 'bookList',
            item: 'book',
            clicked: '$clicked',
            titleTag: 'h3',
            reloadDelay: 300
          };
          angular.extend(properties, scope.$eval(attrs.rjsScroller));
          $log.debug(properties);
          
          // 목록 변경 체크
          scope.$watch(function() {
            return scope.$eval(properties.list + '.length');
          }, function(newLength) {
            $log.debug(newLength);
            
            // 목록 재 로드시 scroller reload 및 top으로 이동
            $timeout(function() {
              $log.debug('reload and slideTo(0)');
            }, properties.reloadDelay);
            // 목록이 없는 경우 무시
            if (newLength === 0) {
              return ;
            }
            var list = scope.$eval(properties.list);
            
            // 각 제목 클릭시 처리
            element.find(properties.titleTag).on('click', function(e) {
              var item = angular.element(e.target).scope()[properties.item];
              if (item[properties.clicked]) {
                $timeout(function() {
                  $log.debug('reload and slideTo(' + item.title + ')');
                }, properties.reloadDelay);
              } else {
                var isAllClosed = true;
                // 모두 다 닫혔는지 확인
                for (var i = 0; i < list.length; i++) {
                  if (true === list[i][properties.clicked]) {
                    isAllClosed = false;
                    break;
                  }
                }
                
                // 모두 다 닫힌경우 reload 후 top으로 열린게 있다면 열리는 쪽에서 reload 처리됨
                if (isAllClosed) {
                  $timeout(function() {
                    $log.debug('all closed, reload and toTop');
                  }, properties.reloadDelay);
                }
              }
              $log.debug(item);
              $log.debug(item[properties.clicked]);
            });
          });
        }
      };
    }];
  });
})(define);