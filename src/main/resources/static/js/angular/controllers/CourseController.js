app.controller('CourseController', ['CourseService','$scope',  function(CourseService, $scope) {
    //var self = this;

    $scope.courses=[];
    $scope.course={};
    $scope.message ='';
    $scope.duration={
        value:0
    };
    $scope.price={
        value:0
    };

    fetchAllCourses();

    function fetchAllCourses() {
        CourseService.fetchAllCourses()
            .then(
                function (d) {
                    $scope.courses = d;
                    console.log($scope.courses);
                },
                function (errorResponse) {
                    console.error(errorResponse);
                })
    }
    $scope.register = function() {
        //$scope.course.price= $scope.duration.value
       // $scope.course.price=$scope.price.value
        console.log($scope.course);
    }
}]);

'use strict';
