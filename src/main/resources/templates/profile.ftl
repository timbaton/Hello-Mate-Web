<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<#--CSS-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">

    <script src="https://kit.fontawesome.com/a0d7d91daf.js"></script>

    <link rel="stylesheet" href="/css/profile.css">

</head>
<body>

<#include "navbar.ftl" />

<div class="container">

    <div class="row h-100" style="vertical-align: center">

        <#if user.avatar?exists>
                <img src="http://localhost:8080/uploads/${user.avatar.path}" class="float-left rounded-circle"
                     alt="avatar" onload="fixAspect(this)">
        <#else>
                <img src="images/avatar.png" class="float-left rounded-circle" alt="avatar">
        </#if>

        <h3 id="user_login"> ${user.login} </h3>


        <div class="col-sm-9">
        <#--<button type="submit" value="/profile/edit" class="btn"><i class="fa fa-trash"></i> Trash</button>-->
            <a href="/profile/edit" class="btn btn-warning"><i class="fa fa-pencil" aria-hidden="true"></i> Edit profile</a>
        </div>

    </div>
    <br>
</div>

<br>

<#--registered events-->
<#include "view_events.ftl" />


<br>
<br>

<#--js-->
<script src="/js/jQuery.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="/js/profile.js"></script>
</body>
</html>
