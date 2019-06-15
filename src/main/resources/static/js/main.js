$(document).ready(function () {

    // GET REQUEST
    $('#getAllCustomerId').click(function (event) {
        event.preventDefault();
        ajaxGet();
    });

    // DO GET
    function ajaxGet() {
        $.ajax({
            type: "GET",
            url: window.location + "/all",
            success: function (result) {
                $('#right ul').empty();
                var custList = "";
                $.each(result, function (i, event) {
                    var customer = " <li class=\"list-group-item\">" + "- Customer with Id = " + i + ", event = " + event.description + ", lastName = " + event.location + "<br>";
                    // var customer = "- Customer with Id = " + "<br>";
                    $('#right .list-group').append(customer)
                });
                console.log("Success: ", result);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert('status:' + XMLHttpRequest.status + ', status text: ' + XMLHttpRequest.statusText);
            }
        });
    }
});
