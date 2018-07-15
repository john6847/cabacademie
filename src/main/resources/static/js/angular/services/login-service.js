/**
 * Created by Dany on 08/07/2018.
 */
'use strict';

app.factory('Login', function ($http, $resource,  $rootScope, Cookies) {
     return{ Login: function(credentials, success, error) {
                $http({
                    method: 'POST',
                    url: '/login',
                    headers: {
                        Authorization: "Basic " + btoa(credentials.username + ":" + credentials.password)
                    }
                }).then(function (resp) {
                    success(resp.data, resp.headers())
                }, error);

        }
     }

});