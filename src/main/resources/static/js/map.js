// In the following example, markers appear when the user clicks on the map.
// Each marker is labeled with a single alphabetical character.
var markers = [];

function initialize() {
    var defoultPosition = {lat: 55.721, lng: 52.373};


    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
        center: defoultPosition,
        streetViewControl: false,
        mapTypeControl: false
    });

    infoWindow = new google.maps.InfoWindow;

    //find user's position
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            defoultPosition = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(defoultPosition);
            infoWindow.setContent('You are here');
            infoWindow.open(map);
            addMarker(defoultPosition, map);
            map.setCenter(defoultPosition);

        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }

    // This event listener calls addMarker() when the map is clicked.
    google.maps.event.addListener(map, 'click', function (event) {
        addMarker(event.latLng, map);
    });

    addMarker(defoultPosition, map);
    // Add a marker at the center of the map.
}

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -34.397, lng: 150.644},
        zoom: 6
    });
}

// Adds a marker to the map.
function addMarker(location, map) {
    // Add the marker at the clicked location, and add the next-available label
    // from the array of alphabetical characters.
    deleteMarkers();

    var marker = new google.maps.Marker({
        position: location,
        // label: labels[labelIndex++ % labels.length],
        map: map
    });
    markers.push(marker);

    saveLocation(marker)
}

function saveLocation(evt) {
    document.getElementById('location').value = evt.position.lat().toFixed(3) + " " + evt.position.lng().toFixed(3);
}

function deleteMarkers() {
    clearMarkers();
    markers = [];
}

function clearMarkers() {
    setMapOnAll(null);
}

function setMapOnAll(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
    infoWindow.open(map);
}

google.maps.event.addDomListener(window, 'load', initialize());
