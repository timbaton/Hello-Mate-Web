function getEventDetails(event) {
    var id = event.target.id;

    $.ajax({
        type: "GET",
        url: "/ajax/post/" + id,
        success: function (result) {
            $('#right ul').empty();
            var custList = "";
            var customer = " <li class=\"list-group-item\">" + "- Customer with Id = " + result.id + ", event = " + result.name + ", time remind: " + showLeftTime(result.date) + "<br>";
            // var customer = "- Customer with Id = " + "<br>";
            $('#right .list-group').append(customer);
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
    return days + " days " + hours + " hours";
}


