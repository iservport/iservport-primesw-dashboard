angular.module('app', ['ngResource', 'ngSanitize', 'emguo.poller'])
.controller('HomeController', ['$http', '$resource', function($http, $resource, poller) {

    var self = this;

    $http.get("/api/home/?entityId=1").then(
        function(data) { self.projects = data.data; }
    )

    $http.get("/api/home/?projectId=1").then(
        function(data) { self.project = data.data; }
    )

}])
;