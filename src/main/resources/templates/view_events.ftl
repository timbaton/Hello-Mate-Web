<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/view_events.css">
</head>

<body>
<div class="container">

    <br>
    <div class="row" id="tableContainer">

        <div class="column left" id="left">
                <#if events?size != 0>
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

                <#else>
                    <li>
                        <a class="list-group-item list-group-item-action">
                            <div id="outer" class="container">
                                <div id="inner">
                                    <p>Зарегестрируйтесь на мероприятие!</p>
                                </div>
                            </div>
                        </a>
                    </li>
                </#if>
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

                <p style="margin-top: 24px" id="description" class="font-weight-light">выберете мероприятия из
                    списка</p>

                <button style="display: none" id="buttonRegister" data-event="${firstEvent.id}"
                        onclick="onRegisterClicked(event)"
                        type="button" class="btn btn-success">Register
                </button>

                <button style="display: none" id="buttonUnRegister" data-event="${firstEvent.id}"
                        onclick="onUnRegisterClicked(event)"
                        type="button" class="btn btn-success">Unregister
                </button>

                <button style="display: none" id="buttonDelete" data-event="${firstEvent.id}"
                        onclick="onDeleteEventClicked(event)"
                        type="button" class="btn btn-danger">Delete
                </button>
            </div>
        </div>
    </div>
</div>

<script src="/js/view_events.js"></script>

</body>
</html>
