angular.module('app', ['ngResource', 'ngSanitize', 'emguo.poller', 'googlechart',])
.controller('HomeController', ['$http', '$resource', function($http, $resource, poller) {

    var self = this;

    $http.get("/api/home/?entityId=1").then(
        function(data) { self.projects = data.data; }
    )

}])
.directive('projectChart', ['$http', function($http) {
    return {
        restrict: 'A',
        scope: { id: '=projectChart'},
        link: function(scope) {
            $http.get("/api/home/?projectId="+scope.id).then( function(data) { scope.projectChart = data.data; } )
        },
        template: '<div class="panel panel-default">'+
        '<div class="panel-body" data-google-chart data-chart="projectChart" style="width:100%;"></div>'+
        '</div>'
    };
}])
;