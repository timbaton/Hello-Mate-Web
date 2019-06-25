<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

<#--styles-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<#include "navbar.ftl" />

<div class="container">
    <div class="row-fluid">

        <div class="col-sm-8" id="left">
            <#list events as event>
               <a id="${event.id}" href="#" class="list-group-item list-group-item-action" onclick="getEventDetails(event)"> ${event.description} </a>
            </#list>
        </div>

        <div class="col-sm-4" id="right">
            <ul class="list-group">
        </div>
    </div>
</div>

<#--js-->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/project.js"></script>
</body>
</html>
