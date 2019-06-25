function fillImages(result) {
    var images = result.images;
    $('#listImages').empty();

    if (images.length > 0) {
        $('#boxshadow').show(410, "linear");
        images.forEach(function (value, key) {
            var image = "<li><img id=\"img\" src=\"uploads/" + value.path + "\"></li>";
            $('#listImages').append(image);
        });
    } else {
        $('#boxshadow').hide();
    }
}

var fillDetailedEvent = function (result) {

    fillImages(result);

    document.getElementById("title").innerHTML = result.title;

    document.getElementById("description").innerHTML = result.description;

};

function getEventDetails(event) {
    var id = event.currentTarget.id;

    $.ajax({
        type: "GET",
        url: "/ajax/post/" + id,
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


