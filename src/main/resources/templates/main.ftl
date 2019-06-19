<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

<#--styles-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/main.css">

<#--js-->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
    <script src="/js/main.js"></script>

</head>
<body>

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
</body>
</html>
