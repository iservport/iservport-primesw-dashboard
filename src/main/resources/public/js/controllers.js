angular.module('app', ['emguo.poller', 'googlechart',])
.controller('HomeController', ['$http', 'poller', function($http, poller) {

    var self = this;

    self.p = poller.get('/api/home', { action: 'get', delay: 60000 });

    self.p.promise.then(null, null, function(data) { self.reports = data.data; self.lastUpdated = new Date(); });

    self.restart = function() { self.p.restart(); }

}])
.directive('projectChart', ['$http', function($http) {
    return {
        restrict: 'A',
        scope: { report: '=projectChart'},
        template: '<div class="panel panel-default"><div class="panel-body" data-google-chart data-chart="report"></div>'+
        '</div>'
    };
}])
;