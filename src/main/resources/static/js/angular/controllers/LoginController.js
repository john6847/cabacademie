/**
 * Created by Dany on 08/07/2018.
 */
'use strict';

app.controller('LoginController', function ($cookies, $http, $location, $rootScope, $q, $resource, $scope, Cookies, Login) {
    var self = this;

    self.credentials = {
        username: '',
        password: ''
    };


    self.login = function () {
        Login.Login(self.credentials, function (data, headers) {
            $localStorage.user = data.user;
            $localStorage.authToken = headers['x-auth-token'];
            $http.defaults.headers.common['x-auth-token'] = headers['x-auth-token'];
            $location.path("/");
        }, function (error) {
            console.log(error);
        });
    };

    self.logout = function () {
        delete $localStorage.user;
        delete $localStorage.authToken;
        $http.defaults.headers.common = {};
    };


    var handleError = function(response) {

        if (response.status === 401) {
            console.error('You need to login first!');

        } else {
            console.error('Something went wrong...', response);
        }
    };
});
