<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <#--styles-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/main.css">

    <#--js-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/main.js"></script>

</head>
<body>

<div class="container">
    <div class="row-fluid">

        <div class="col-sm-8" id="left">
            <#list events as event>
                <li class="list-group-item">${event.description}</a></li>
            </#list>
        </div>

        <div class="col-sm-4" id="right">
            <ul class="list-group">
        </div>

        <div class="col-sm-7" style="margin:20px 0px 20px 0px">
            <button id="getAllCustomerId" type="button" class="btn btn-primary">Get All Customers</button>
        </div>
    </div>
</div>
</body>
</html>
