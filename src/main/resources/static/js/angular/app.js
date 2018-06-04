'use strict'
var app = angular.module('cabAcademie', ['ui.router'])

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    // var courseStates =[
    //     {
    //         name:'course',
    //         url:'/course',
    //         templateUrl:'course',
    //         controller:'CourseController as cctrl',
    //         resolve:{
    //             async:['CourseService', function(CourseService){
    //                 return CourseService.fetchAllCourses();
    //             }]
    //         }
    //     },{
    //         name:'course.list',
    //         url:'/{courseId:[A-Za-z]{0,9}}',
    //         templateUrl: function(params){return 'course/'+params.courseId;},
    //         controller:'CourseController as cctrl',
    //         resolve:{
    //             async:['CourseService', '$stateParams', function(CourseService, $stateParams ){
    //                 return CourseService.fetchAllItems($stateParams.courseId);
    //             }]
    //         }
    //     },{
    //         name:'course.list.detail',
    //         url:'/{itemId:[0-9]{1,9}}',
    //         templateUrl: function(params){return 'course/'+params.courseId+'/'+params.itemId;},
    //         controller:'CourseController as cctrl',
    //         resolve:{
    //             async:['CourseService', '$stateParams', function(CourseService, $stateParams ){
    //                 return CourseService.fetchSpecificItem($stateParams.courseId,$stateParams.itemId);
    //             }]
    //         }
    //     }
    // ];

    var loginState =[
        {
            name:'login',
            url:'/login',
            templateUrl:'partials/login.html',
            controller:'LoginController as lctrl'
        }
    ]

    var homeState =[
        {
            name:'home',
            url:'/home',
            templateUrl:'partials/home.html',
            controller:'HomeController as hctrl'
        }
    ]

     $stateProvider.state(homeState);
     $stateProvider.state(loginState);
    // $stateProvider.state(courseStates[1]);
    // $stateProvider.state(courseStates[2]);

}])



app.run(['$rootScope', '$state', '$stateParams',
        function ($rootScope,   $state,   $stateParams) {

            // It's very handy to add references to $state and $stateParams to the $rootScope
            // so that you can access them from any scope within your applications.For example,
            // <li ng-class="{ active: $state.includes('contacts.list') }"> will set the <li>
            // to active whenever 'contacts.list' or one of its decendents is active.
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
        }
    ]
)