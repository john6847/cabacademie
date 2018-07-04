'use strict'
var app = angular.module('cabAcademie', ['ngRoute', 'ngMaterial','ngMessages']);

app.config(['$routeProvider', function($routeProvider){

    $routeProvider
        .when('/login',{
            templateUrl:'login',
            controller:"LoginController as l_ctrl"
        })
        .when('/home',{
            templateUrl:'/home',
            controller:"HomeController as h_ctrl"
        })
        .when('/course',{
            templateUrl:'course',
            controller:"CourseController as c_ctrl"
        })
        .when('/registerCourse',{
            templateUrl:'registerCourse',
            controller:"CourseController as rc_ctrl"
        })
        .when('/category/add',{
            templateUrl:'category',
            controller:"CategoryController as cat_ctrl"
        })
        .otherwise({redirectTo:'/home'})

    // var loginState =
    //     {
    //         name:'login',
    //         url:'/login',
    //         templateUrl:'partials/login.ftl',
    //         controller:'LoginController'
    //     };
    //
    // var homeState =
    //     {
    //         name:'home',
    //         url:'/home',
    //         templateUrl:'partials/home.ftl',
    //         controller:'HomeController'
    //     };
    // var courseStates =[
    //     {
    //         name:'course',
    //         url:'/course',
    //         templateUrl:'partials/course.ftl',
    //         controller:'CourseController'
    //     },
    //     {
    //         name:'registercourse',
    //         url:'/registercourse',
    //         templateUrl:'partials/register_course.ftl',
    //         controller:'CourseController'
    //     }
    //     ];
        //,{
        //     name:'course.list',
        //     url:'/{courseId:[A-Za-z]{0,9}}',
        //     templateUrl: function(params){return 'course/'+params.courseId;},
        //     controller:'CourseController as cctrl',
        //     resolve:{
        //         async:['CourseService', '$stateParams', function(CourseService, $stateParams ){
        //             return CourseService.fetchAllItem($stateParams.courseId);
        //         }]
        //     }
        // },{
        //     name:'course.list.detail',
        //     url:'/{itemId:[0-9]{1,9}}',
        //     templateUrl: function(params){return 'course/'+params.courseId+'/'+params.itemId;},
        //     controller:'CourseController as cctrl',
        //     resolve:{
        //         async:['CourseService', '$stateParams', function(CourseService, $stateParams ){
        //             return CourseService.fetchSpecificItem($stateParams.courseId,$stateParams.itemId);
        //         }]
        //     }
        // }

    // $stateProvider.state(courseStates[0]);
    // $stateProvider.state(courseStates[1]);
    // $stateProvider.state(homeState);
    // $stateProvider.state(loginState);
    // $stateProvider.state(courseStates[2]);

}]);

// app.run(['$rootScope', '$state', '$stateParams',
//         function ($rootScope,   $state,   $stateParams) {
//
//             // It's very handy to add references to $state and $stateParams to the $rootScope
//             // so that you can access them from any scope within your applications.For example,
//             // <li ng-class="{ active: $state.includes('contacts.list') }"> will set the <li>
//             // to active whenever 'contacts.list' or one of its decendents is active.
//             $rootScope.$state = $state;
//             $rootScope.$stateParams = $stateParams;
//         }
//     ]
// );


// md-card configuration
app.controller('AppCtrl', function($scope) {
    $scope.imagePath = 'img/washedout.png';
});
app.config(['$mdThemingProvider', function($mdThemingProvider) {
    $mdThemingProvider.theme('dark-grey').backgroundPalette('grey').dark();
    $mdThemingProvider.theme('dark-orange').backgroundPalette('orange').dark();
    $mdThemingProvider.theme('dark-purple').backgroundPalette('deep-purple').dark();
    $mdThemingProvider.theme('dark-blue').backgroundPalette('blue').dark();
}]);

