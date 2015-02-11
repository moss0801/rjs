define([
  'text!templates/home.html',
  'text!templates/valid.html',
  'text!templates/test.html',
  'text!templates/sly.html',
  'text!templates/scroll.html',
  'text!templates/dynamicColumn.html',
  'text!templates/ticketTable.html',
  'text!templates/tinymce.html',
  'text!templates/manyTab.html',
  'text!templates/input.html'
  ], function (home, valid, test, sly, scroll, dynamicColumn, ticketTable, tinymce, manyTab, input) {
  'use strict';
  return ['$locationProvider', '$stateProvider', '$urlRouterProvider', 
    function ($locationProvider, $stateProvider, $urlRouterProvider) {
      $locationProvider.html5Mode(true);
      $urlRouterProvider.otherwise("/");
      $stateProvider
        .state('home', {
          url: '/',
          template: home
        })
        .state('valid', {
          url: '/valid',
          template: valid,
          controller: 'validController'
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
        .state('scroll', {
          url: '/scroll',
          controller: 'scrollController',
          template: scroll
        })
        .state('dynamicColumn', {
          url: '/dynamicColumn',
          controller: 'dynamicColumnController',
          template: dynamicColumn
        })
        .state('ticketTable', {
          url: '/ticketTable',
          controller: 'ticketTableController',
          template: ticketTable
        })
        .state('tinymce', {
          url: '/tinymce',
          controller: 'tinymceController',
          template: tinymce
        })
        .state('manyTab', {
          url: '/manyTab',
          controller: 'manyTabController',
          template: manyTab
        })
        .state('input', {
          url: '/input',
          template: input
        })
        ;
  }];
});