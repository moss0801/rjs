define([
  'text!templates/home.html',
  'text!templates/test.html',
  'text!templates/sly.html'
  ], function (home, test, sly) {
  'use strict';
  return ['$locationProvider', '$stateProvider', '$urlRouterProvider', 
    function ($locationProvider, $stateProvider, $urlRouterProvider) {
      $locationProvider.html5Mode(true);
      $urlRouterProvider.otherwise("/");
      $stateProvider
        .state('home', {
          url: '/?test',
          template: home
        })
        .state('test', {
          url: '/test',
          template: test
        })
        .state('sly', {
          url: '/sly',
          controller: 'slyController',
          template: sly
        })
        ;
  }];
});