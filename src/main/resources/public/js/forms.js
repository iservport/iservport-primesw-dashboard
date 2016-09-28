angular.module('app')
.directive('locationForm', ['$http', function($http) {
    return {
        link: function(scope) {
            $http.get("/api/home/location").success(function(data) { scope.configLocation = data.data; });
            scope.updateConfig = function() {
            };
        },
        templateUrl: '/static/home/home-modal.html'
    };
}])