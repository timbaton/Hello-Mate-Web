<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

<#--styles-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

    <#include "navbar.ftl" />

<div class="container">

    <br>
    <br>
<#--<div class="card bg-light">-->
<#--<article class="card-body mx-auto" style="max-width: 400px;">-->
    <div class="row">

        <div class="column left" id="left">
            <#list events as event>
                <li>
                    <a style="height: 150px; width: 100%;" id="${event.id}" data-id="${event.id}" href="#"
                       class="list-group-item list-group-item-action"
                       onclick="getEventDetails(event)">
                        <h3 style="color: #000000">${event.title}</h3>
                        <h6 style="text-align: left; vertical-align: bottom">${event.showTimeBefore()}</h6>
                    </a>

                </li>

            </#list>
        </div>

        <div class="column right" id="right">
            <div class="container">
                <h1 id="title">${firstEvent.title}</h1>
                <br>

            <#--Images-->
                <div class="container" id="boxshadow" style="width: 800px">
                    <ul id="listImages">
                    <#list firstEvent.images as image>
                        <li>
                            <img id="img" src="uploads/${image.path}">
                        </li>
                    </#list>
                    </ul>
                </div>

                <p style="margin-top: 24px" id="description" class="font-weight-light">${firstEvent.description}</p>

                <#if !hasRegistered??>
                      <button id="buttonRegister" data-event="${firstEvent.id}" onclick="onRegisterClicked(event)"
                              type="button" class="btn btn-success">Register
                      </button>
                </#if>
            </div>
        </div>
    </div>
<#--</article>-->
<#--</div>-->
</div>


<#--js-->
<#--<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>-->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/project.js"></script>
</div>
</body>
</html>
