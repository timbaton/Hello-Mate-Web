function fillImages(result) {
    var images = result.images;
    $('#listImages').empty();

    if (images.length > 0) {
        $('#boxshadow').show(410, "linear");
        images.forEach(function (value, key) {
            var image = "<li><img id=\"img\" src=\"http://localhost:8080/uploads/" + value.path + "\"></li>";
            $('#listImages').append(image);
        });
    } else {
        $('#boxshadow').hide();
    }
}

function fillDetailedEvent(event, userId) {

    fillImages(event);

    document.getElementById("title").innerHTML = event.title;

    document.getElementById("description").innerHTML = event.description;

    document.getElementById("buttonRegister").dataset.event = event.id;

    document.getElementById("buttonDelete").dataset.event = event.id;


    var owner = event.owner;
    var id = owner.id;
    var b = userId === id;
    if (!b) {
        $('#buttonDelete').hide();
    } else {
        $('#buttonDelete').show(410, "linear");
    }
}

function getEventDetails(event) {
    var id = event.currentTarget.id;

    $.ajax({
        type: "GET",
        url: "/ajax/post/" + id,
        success: function (result) {
            fillDetailedEvent(result.event, result.userId);

            console.log("Success: ", result);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert('status:' + XMLHttpRequest.status + ', status text: ' + XMLHttpRequest.statusText);
        }
    })
}

function onRegisterClicked(event) {
    var id = event.currentTarget.dataset.event;

    $.ajax({
        type: "POST",
        url: "/ajax/event_details/" + id,
        success: function (result) {
            fillDetailedEvent(result);

            console.log("Success: ", result);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert('status:' + XMLHttpRequest.status + ', status text: ' + XMLHttpRequest.statusText);
        }
    })
}

function onDeleteEventClicked(event) {
    var id = event.currentTarget.dataset.event;

    $.ajax({
        type: "POST",
        url: "/ajax/event_delete/" + id,
        success: function (result) {
            fillDetailedEvent(result);

            console.log("Success: ", result);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert('status:' + XMLHttpRequest.status + ', status text: ' + XMLHttpRequest.statusText);
        }
    })
}

function showLeftTime(time) {
    var date1, date2;

    date1 = new Date().valueOf();

    date2 = new Date(time).getTime();

    var res = Math.abs(date1 - date2) / 1000;

// get total days between two dates
    var days = Math.floor(res / 86400);

// get hours
    var hours = Math.floor(res / 3600) % 24;

    var minutes = Math.floor(res / 60) % 60;
    return days + " days " + hours + " hours " + minutes + " min";
}


