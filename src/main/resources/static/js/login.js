var appId = "6770852";
var getTokenUri = "https://oauth.vk.com/authorize?client_id=" + appId +"&display=popup&redirect_uri=http://localhost:8080/login&response_type=token&revoke=1&v=5.101";


var token_key = "access_token";
var user_id_key = "user_id";

var user_id = null;
var token = null;

document.getElementById("vk").addEventListener("click", function(event){
    event.preventDefault();
    window.location = getTokenUri;

});

window.onload = function (ev) {
    getAllUrlParams(window.location.href);

    if (token != null && user_id != null) {
        getUsersData(token, user_id);
    }
};

function getAllUrlParams(url_string) {
    var url_replaced = url_string.replace('#', '?');
    var url = new URL(url_replaced);
    token = url.searchParams.get(token_key);
    user_id = url.searchParams.get(user_id_key);
}

function getUsersData(token, user_id) {
    var url = "https://api.vk.com/method/users.get?user_ids=" + user_id + "&access_token=" + token + "&v=5.101&fields=screen_name,contacts";
    $.ajax({
        url: url,
        type: 'GET',
        crossDomain: true,
        dataType: 'jsonp',
        success: function (data) {
            saveUser(data)
        },
        error: function () {
            alert('Failed!');
        }
    });

}

function saveUser(data) {
    var user = data.response[0];

    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(user),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        url: "/login_vk",
        success: function (data) {
            window.location.replace("http://localhost:8080/main");
        },
        error: function () {
            alert('Failed!');
        }
    })
}
