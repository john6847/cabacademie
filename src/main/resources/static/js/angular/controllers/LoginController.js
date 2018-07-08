'use strict';

app.controller('LoginController',function ($location, $scope, $q, $rootScope, $http) {
        var self = this;

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

    self.credentials = {};
    self.login = function () {
            authenticate(self.credentials, function () {
                console.log($rootScope)
                if ($rootScope.authenticated) {


                    $location.path("/home");
                    self.error = false;
                } else {
                    $location.path("/login");
                    self.error = true;
                }
            });
        };


    self.logout = function() {
            $http.post('logout', {})
                .then(function() {

                    $rootScope.authenticated = false;
                    $location.path("/home");
                },function(error) {
                    console.log(error);
                    $rootScope.authenticated = false;
                });
        }
 });