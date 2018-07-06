app.controller('CourseController', ['CourseService','CategoryService','$scope', function(CourseService,CategoryService, $scope) {
    var self = this;

    self.categories=[];
    self.courses=[];
    self.course={ id:0, price: '', duration: '', title: '', syllabus:{}, startDate: null, category:{}, premium: false, localUser:{}};
    self.message ='';

    fetchAllCategories();

    function fetchAllCategories() {
        CategoryService.fetchAllCategories()
            .then(
                function (d) {
                    self.categories = d;
                    console.log(self.categories);
                },
                function (errorResponse) {

                    console.error(errorResponse);
                })
    }

    fetchAllCourses();

    function fetchAllCourses() {
        CourseService.fetchAllCourses()
            .then(
                function (d) {
                    self.courses = d;
                    console.log(self.courses);
                },
                function (errorResponse) {
                    console.error(errorResponse);
                })
    }

    self.register = function() {
        //$scope.course.duration= $scope.duration.value;
       // $scope.course.price = $scope.price.value;
        console.log(self.course);
    }

    self.ver = function(){
        console.log(self.course.price)
    }
}]);


'use strict';
