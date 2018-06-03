'use strict'; 

app.factory('CourseService',['$http', '$q', function($http, $q){
    return{
        fetchAllCourses:function(){ // fetching all courses from backend
           return $http.get('/api/course/')
                .then(function(response){
                    return response.data;
                },function(error){
                    console.log('Error while fetching Course')
                    return $q.rejct(error);
                }
            ) 
        },
        fetchAllItem: function(){}, 
        fetchSpecificItem: function(){}

    }
}])