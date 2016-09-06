<%--
  Created by IntelliJ IDEA.
  User: jan.husenica
  Date: 8/8/2016
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="mainApp">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
    <script src="https://cdn.rawgit.com/auth0/angular-jwt/master/dist/angular-jwt.js"></script>
    <script src="https://cdn.rawgit.com/auth0/angular-storage/master/dist/angular-storage.js"></script>
    <script src="<c:url value='/static/js/LiptovZije.js' />"></script>
    <script src="<c:url value='/static/js/users/Users.js' />"></script>
    <script src="<c:url value='/static/js/users/UserService.js' />"></script>
    <script src="<c:url value='/static/js/users/UserController.js' />"></script>
    <script>
        $(document).ready(function(){
            $(".dropdown").hover(
                    function() {
                        $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
                        $(this).toggleClass('open');
                    },
                    function() {
                        $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
                        $(this).toggleClass('open');
                    }
            );
        });
    </script>
</head>
    <body ng-controller="userController as ctrl">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Liptov Žije</a>
                </div>

                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Domov</a></li>
                    <li><a href="#">Udalosti</a></li>
                    <li><a href="#">Články</a></li>
                    <li class="dropdown">
                        <a href="#users">Užívateľia
                        <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#users/new">Registrácia</a></li>
                            <li><a href="#">sublist 1</a></li>
                            <li><a href="#">sublist 2</a></li>
                        </ul>
                    </li>
                </ul>

                <form ng-submit="ctrl.submit()" id="sign-in-form" class="navbar-form navbar-right">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input ng-model="ctrl.name" class="form-control" value="" placeholder="Vaša emailová adresa">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input ng-model="ctrl.pass" type="password" class="form-control" value="" placeholder="Vaše heslo">
                    </div>
                    <button type="submit" class="btn btn-primary">Prihlásiť</button>
                </form>
            </div>
        </nav>

AHOJ

        <div ng-view></div>
    </body>
</html>
