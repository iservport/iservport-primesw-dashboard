angular.module('app', ['ngResource', 'ngSanitize', 'emguo.poller'])
.controller('HomeController', ['$http', '$resource', function($http, $resource, poller) {

    var self = this;

    $http.get("/api/home/?reportId=1").then(
        function(data) { self.report = data.data; }
    )

}])
;