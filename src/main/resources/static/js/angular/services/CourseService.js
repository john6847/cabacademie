'use strict'; 
angular.module('cabAcademie').factory('CourseService',['$http', '$q', function($http, $q){
    return{
        fetchAllCourses:function(){ // fetching all courses from backend
            var deferred = $q.defer();
            $http.get('/api/course/')
                .then(function(response){
                    deferred.resolve(response.data);
                },function(error){
                    console.error(error);
                    deferred.reject(error);
                }
            );
            return deferred.promise;
        },
        fetchAllItem: function(){}, 
        fetchSpecificItem: function(){}

    }
}]);