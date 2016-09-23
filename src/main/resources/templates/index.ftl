[#ftl]
<html>
<head>
    <meta content="text/html; iso-8859-1" http-equiv="content-type">
    <meta http-equiv="content-language" content="${.locale!'pt-BR'}" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/dist/css/bootstrap.min.css'>
    <link rel='stylesheet' href="/webjars/fontawesome/4.6.3/css/font-awesome.css">
    <script type="text/javascript" src="/webjars/jquery/2.2.4/dist/jquery.min.js"></script>
    <title>Dashboard</title>
</head>
<body id="ng-app" xmlns:ng="http://angularjs.org" data-ng-app="app" data-ng-controller="HomeController as home">

    <div class="container">
        <h1>Projetos</h1>
        <div class="row">
            <div class="col-md-4">
                <div class="well" data-ng-repeat="project in home.projects">
                    <h4>Projeto {{project.projectName}}</h4>
                </div>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-6" data-ng-repeat="id in [1,2,3,4]" data-project-chart="id">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="/webjars/angular/1.5.8/angular.min.js"></script>
    <script type="text/javascript" src="/webjars/angular-sanitize/1.5.8/angular-sanitize.min.js"></script>
    <script type="text/javascript" src="/webjars/angular-resource/1.5.8/angular-resource.min.js"></script>
    <script type="text/javascript" src="/webjars/angular-animate/1.5.8/angular-animate.min.js"></script>
    <script type="text/javascript" src="/webjars/angular-i18n/1.5.8/angular-locale_${locale_!'pt-br'}.js"></script>
    <script type="text/javascript" src="/webjars/angularpoller/0.3.2/angular-poller.min.js"></script>
    <script type="text/javascript" src="./target/scala-2.11/helianto-spring-fastopt.js"></script>
    <script type="text/javascript" src="/js/controllers.js"></script>
    <script type="text/javascript" src="/webjars/angular-google-chart/0.1.0/ng-google-chart.min.js"></script>

</body>
</html>