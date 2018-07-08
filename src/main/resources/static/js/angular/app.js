//'use strict'
var app = angular.module('cabAcademie', ['ngRoute', 'ngCookies', 'ngResource', 'ngMaterial','ngMessages']);

app.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider){
    $httpProvider.defaults.withCredentials= true;
    // $httpProvider.defaults.xsrfCookieName ='CSRF_TOKEN';
    // $httpProvider.defaults.xsrfHeaderName= 'X-CSRF-TOKEN';

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

app.directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^0-9]/g, '');

                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});

app.directive('onlyNumbers', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^0-9\.]/g, '');

                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});


app.directive('ngDecimal', function(){
    return {
        restrict: 'A',
        link: function($scope, $element, $attributes){
            var limit = $attributes.ngDecimal;
            function caret(node) {
                if(node.selectionStart) {
                    return node.selectionStart;
                }
                else if(!document.selection) {
                    return 0;
                }
                //node.focus();
                var c		= "\001";
                var sel	= document.selection.createRange();
                var txt	= sel.text;
                var dul	= sel.duplicate();
                var len	= 0;
                try{ dul.moveToElementText(node); }catch(e) { return 0; }
                sel.text	= txt + c;
                len		= (dul.text.indexOf(c));
                sel.moveStart('character',-1);
                sel.text	= "";
                return len;
            }
            $element.bind('keypress', function(event){
                var charCode = (event.which) ? event.which : event.keyCode;
                var elem=document.getElementById($element.attr("id"));
                if (charCode == 45){
                    var caretPosition=caret(elem);
                    if(caretPosition==0){
                        if($element.val().charAt(0)!="-" ){
                            if($element.val() <=limit){
                                $element.val("-"+$element.val());
                            }
                        }
                        if($element.val().indexOf("-")!=-1){
                            event.preventDefault();
                            return false;
                        }
                    }
                    else{
                        event.preventDefault();
                    }
                }
                if (charCode == 46){
                    if($element.val().length>limit-1){
                        event.preventDefault();
                        return false;
                    }
                    if ($element.val().indexOf('.') !=-1){
                        event.preventDefault();
                        return false;
                    }
                    return true;
                }
                if (charCode != 45 && charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)){
                    event.preventDefault();
                    return false;
                }
                if($element.val().length>limit-1){
                    event.preventDefault();
                    return false;
                }
                return true;
            });
        }
    };
});