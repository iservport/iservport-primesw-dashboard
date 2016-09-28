[#ftl]
<html>
<head>
    <meta content="text/html; iso-8859-1" http-equiv="content-type">
    <meta http-equiv="content-language" content="${.locale!'pt-BR'}" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css'>
    <link rel='stylesheet' href="/webjars/fontawesome/4.6.3/css/font-awesome.css">
    <link rel='stylesheet' href='/css/iservport.css'>
    <script type="text/javascript" src="/webjars/jquery/2.2.4/dist/jquery.min.js"></script>
    <title>Dashboard</title>
</head>
<body id="ng-app" xmlns:ng="http://angularjs.org" data-ng-app="app" data-ng-controller="HomeController as home">

    <div class="container">
        <div class="row">
            <div class="col-md-4"><img src="/images/prime-logo-sticky.png" style="margin: 12px 0;"></div>
            <div class="col-md-4 text-center"><h1 class="text-primary">Dashboard</h1></div>
            <div class="col-md-4">
                <div class="update-nag pull-right">
                    <div class="update-split"><i class="glyphicon glyphicon-refresh"></i></div>
                    <div class="update-text">{{home.lastUpdated | date : 'medium' : '-0300'}}
                        <a data-ng-click="home.restart()">Atualizar</a> </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4" data-ng-repeat="r in home.reports" >
                <div data-project-chart="r"></div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalAlert" data-backdrop="static" tabindex="-1" role="dialog">
        <div data-home-modal ></div>
    </div>

    <script type="text/javascript" src="/webjars/angular/1.5.8/angular.min.js"></script>
    <script type="text/javascript" src="/webjars/angular-i18n/1.5.8/angular-locale_${locale_!'pt-br'}.js"></script>
    <script type="text/javascript" src="/webjars/angularpoller/0.3.2/angular-poller.min.js"></script>
    <script type="text/javascript" src="./target/scala-2.11/helianto-spring-fastopt.js"></script>
    <script type="text/javascript" src="/js/controllers.js"></script>
    <script type="text/javascript" src="/js/forms.js"></script>
    <script type="text/javascript" src="/webjars/angular-google-chart/0.1.0/ng-google-chart.min.js"></script>

</body>
</html>