'use strict';

app.controller('LoginController',function ($location, $scope, $q, $rootScope, $http) {
        var authenticate = function (credentials, callback) {

            var headers = credentials ? {
                authorization: "Basic "
                + btoa(credentials.username + ":" + credentials.password)
            } : {};
            $http.get('/api/login/user', {headers: headers})
                .then(function (data) {
                    if (data.name) {
                        $rootScope.authenticated = true;
                    } else {
                        $rootScope.authenticated = false;
                    }
                    callback && callback();
                }, function (error) {
                    $rootScope.authenticated = false;
                    console.log(error);
                    callback && callback()
            });
        };

        authenticate();
        $scope.credentials = {};
        $scope.login = function () {
            authenticate($scope.credentials, function () {
                if ($rootScope.authenticated) {
                    $location.path("/");
                    $scope.error = false;
                } else {
                    $location.path("/login");
                    $scope.error = true;
                }
            });
        };


        $scope.logout = function() {
            $http.post('logout', {})
                .then(function() {
                    $rootScope.authenticated = false;
                    $location.path("/");
                },function(error) {
                    console.log(error);
                    $rootScope.authenticated = false;
                });
        }
 });