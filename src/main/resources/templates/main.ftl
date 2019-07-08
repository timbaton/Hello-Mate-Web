<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<#--CSS-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

    <#include "navbar.ftl" />

<div class="container">

    <br>
    <div class="row" id="tableContainer">

        <div class="column left" id="left">
            <#list events as event>
                <li>
                    <a style="height: 150px; width: 100%;" id="${event.id}" data-id="${event.id}"
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
                <h1 style="display: none" id="title">${firstEvent.title}</h1>
                <br>

            <#--Images-->
                <div style="display: none" class="container" id="boxshadow" style="width: 800px">
                    <ul id="listImages">
                        <#list firstEvent.images as image>
                            <li>
                                <img id="img" src="uploads/${image.path}">
                            </li>
                        </#list>
                    </ul>
                </div>

                <p style="margin-top: 24px" id="description" class="font-weight-light">выберете мероприятия из списка</p>

                <button style="display: none" id="buttonRegister" data-event="${firstEvent.id}" onclick="onRegisterClicked(event)"
                        type="button" class="btn btn-success">Register
                </button>

                <button style="display: none" id="buttonDelete" data-event="${firstEvent.id}" onclick="onDeleteEventClicked(event)"
                        type="button" class="btn btn-danger">Delete
                </button>
            </div>
        </div>
    </div>
</div>


<#--js-->
<script src="/js/jQuery.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="/js/main.js"></script>
<script src="/js/project.js"></script>
</body>
</html>
