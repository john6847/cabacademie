'use strict'
var app = angular.module('cabAcademie', ['ui.router'])

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    var courseStates =[
        {
            name:'course', 
            url:'/course',
            templateUrl:'course',
            controller:'CourseController as cctrl',
            resolve:{
                async:['CourseService', function(CourseService){
                    return CourseService.fetchAllCourses();
                }]
            }
        },{
            name:'course.list',
            url:'/{courseId:[A-Za-z]{0,9}}',
            templateUrl: function(params){return 'course/'+params.courseId;}, 
            controller:'CourseController as cctrl',
            resolve:{
                async:['CourseService', '$stateParams', function(CourseService, $stateParams ){
                    return CourseService.fetchAllItems($stateParams.courseId);
                }]
            }
        },{
            name:'course.list.detail',
            url:'/{itemId:[0-9]{1,9}}',
            templateUrl: function(params){return 'course/'+params.courseId+'/'+params.itemId;}, 
            controller:'CourseController as cctrl',
            resolve:{
                async:['CourseService', '$stateParams', function(CourseService, $stateParams ){
                    return CourseService.fetchSpecificItem($stateParams.courseId,$stateParams.itemId);
                }]
            }
        }
    ];

    $stateProvider.state(courseStates[0]);
    $stateProvider.state(courseStates[1]);
    $stateProvider.state(courseStates[2]);

}])