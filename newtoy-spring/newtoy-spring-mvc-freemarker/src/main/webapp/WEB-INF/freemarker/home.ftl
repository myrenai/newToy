<!doctype html>
<html class="no-js">
<head>
    <#assign baseURL = "/newtoy-springmvc-freemarker" />
    <script>
        var baseURL = "${baseURL}";
    </script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <base href="/">
    <title>freemarker + AngularJS Document Manager</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- css -->
    <link rel="stylesheet" href="${baseURL}/webjars/bootstrap/3.3.5/css/bootstrap.css" />
    <link rel="stylesheet" href="${baseURL}/webjars/angular-tree-control/0.2.12/css/tree-control.css" />
    <link rel="stylesheet" href="${baseURL}/webjars/angular-tree-control/0.2.12/css/tree-control-attribute.css" />
    
    <link rel="stylesheet" href="${baseURL}/resources/css/app.css" />
</head>

<body ng-app="myDocumentManagerApp">

<div ui-view="">test</div>

    <!-- js -->
    <script src="${baseURL}/webjars/jquery/2.1.4/jquery.js"></script>
    <script src="${baseURL}/webjars/ace/01.08.2014/src/ace.js"></script>
    <script src="${baseURL}/webjars/angularjs/1.4.7/angular.js"></script>
    <script src="${baseURL}/webjars/angular-ui-bootstrap/0.13.3/ui-bootstrap-tpls.js"></script>
    <script src="${baseURL}/webjars/angular-ui-router/0.2.15/angular-ui-router.js"></script>
    <script src="${baseURL}/webjars/angular-tree-control/0.2.12/angular-tree-control.js"></script>
    
    <script src="${baseURL}/resources/app.js"></script>
    <script src="${baseURL}/resources/navbar/navbar.controller.js"></script>
    <script src="${baseURL}/resources/main/main.js"></script>
    <script src="${baseURL}/resources/main/main.controller.js"></script>
    <script src="${baseURL}/resources/menu1/menu1.js"></script>
    <script src="${baseURL}/resources/menu1/menu1.controller.js"></script>
</body>
</html>