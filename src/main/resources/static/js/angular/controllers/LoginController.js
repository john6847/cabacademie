'use strict';

app.controller('LoginController',function () {
    $http.get('/api/login/user').success(function (data) {
        $scope.greeting=data;
    })
})