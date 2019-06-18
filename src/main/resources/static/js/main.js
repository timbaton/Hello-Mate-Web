function getEventDetails(event) {
    var id = event.target.id;

    $.ajax({
        type: "GET",
        url: "/ajax/post/" + id,
        success: function (result) {
            $('#right ul').empty();
            var custList = "";
            var customer = " <li class=\"list-group-item\">" + "- Customer with Id = " + result.id + ", event = " + result.name + ", lastName = " + result.location + "<br>";
            // var customer = "- Customer with Id = " + "<br>";
            $('#right .list-group').append(customer)
            console.log("Success: ", result);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert('status:' + XMLHttpRequest.status + ', status text: ' + XMLHttpRequest.statusText);
        }
    })
}
