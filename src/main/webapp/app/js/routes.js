define([], function () {
    'use strict';
    return ['$locationProvider', '$stateProvider', '$urlRouterProvider', 
      function ($locationProvider, $stateProvider, $urlRouterProvider) {
        $locationProvider.html5Mode(true);
        //$urlRouterProvider.otherwise("/");
      
        $stateProvider
          .state('home', {
            url: '/',
            template: 'home'
          })
          .state('test', {
            url: '/test',
            template: 'test'
          })
          ;
    }];
});