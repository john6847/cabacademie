app.controller('CourseController', ['CourseService','$scope', function(CourseService, $scope) {
    var self = this;



    // $scope.price = {
    //     value:2
    // };
    //
    // self.$watch('course.price',function(val,old){
    //     self.course.price = parseInt(val);
    // });
    //
    // $scope.$watch('course.duration',function(val,old){
    //     $scope.course.duration = parseInt(val);
    // });

    self.courses=[];
    self.course={ id:0, price: '', duration: '', title: '', syllabus:{}, startDate: null, category:{}, premium: false, localUser:{}};
    self.message ='';


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

'use strict';
