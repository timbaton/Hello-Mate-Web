// In the following example, markers appear when the user clicks on the map.
// Each marker is labeled with a single alphabetical character.
var markers = [];

function findUsersPosition(defaultPosition, map) {
    infoWindow = new google.maps.InfoWindow;


    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            defaultPosition = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(defaultPosition);
            infoWindow.setContent('You are here');
            infoWindow.open(map);
            addMarker(defaultPosition, map);
            map.setCenter(defaultPosition);

        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
    return defaultPosition;
}

function initChooserMap() {
    var defaultPosition = {lat: 55.721, lng: 52.373};


    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
        center: defaultPosition,
        streetViewControl: false,
        mapTypeControl: false
    });


    //find user's position and put marker on it
    var position = findUsersPosition(defaultPosition, map);
    addMarker(position, map);


    //click listener
    google.maps.event.addListener(map, 'click', function (event) {
        addMarker(event.latLng, map);
    });

}

function initStaticMap(lat, lng) {

    var eventPosition = {lat: lat, lng: lng};

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
        center: eventPosition,
        streetViewControl: false,
        mapTypeControl: false
    });

    addMarker(eventPosition, map);

    //find user's position
    findUsersPosition(eventPosition, map)
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
