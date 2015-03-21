/**
 * 
 */

// Code for google maps integration
var map;
var geocoder;
var marker;
function initialize() {
	var mapOptions = {
		zoom : 8,
		// pass this data to load a page with default cordinates
		center : new google.maps.LatLng(-34.397, 150.644)
	};
	geocoder = new google.maps.Geocoder();
	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

}
google.maps.event.addDomListener(window, 'load', initialize);

// call this method to find current location
function locateMyLocation() {

	var mapOptions = {
		zoom : 8,

	};
	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
	// Try HTML5 geolocation
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = new google.maps.LatLng(position.coords.latitude,
					position.coords.longitude);

			// var infowindow = new google.maps.InfoWindow({
			// map : map,
			// position : pos,
			// content : 'Location found using HTML5.'
			// });

			map.setCenter(pos);

			marker = new google.maps.Marker({
				map : map,
				draggable : true,
				animation : google.maps.Animation.DROP,
				position : pos
			});
			updateLocationData();
			google.maps.event.addListener(marker, 'click', toggleBounce);
			google.maps.event
					.addListener(marker, 'dragend', updateLocationData);

		}, function() {
			handleNoGeolocation(true);
		});
	} else {
		// Browser doesn't support Geolocation
		handleNoGeolocation(false);
	}

	// handles error if at the time of selection
	function handleNoGeolocation(errorFlag) {
		if (errorFlag) {
			var content = 'Error: The Geolocation service failed.';
		} else {
			var content = 'Error: Your browser doesn\'t support geolocation.';
		}

		var options = {
			map : map,
			position : new google.maps.LatLng(60, 105),
			content : content
		};

		var infowindow = new google.maps.InfoWindow(options);
		map.setCenter(options.position);

	}
}

// function for toggle
function toggleBounce() {

	if (marker.getAnimation() != null) {
		marker.setAnimation(null);
	} else {
		marker.setAnimation(google.maps.Animation.BOUNCE);
	}
}

// clear all pointer on map
function clearlistner() {
	google.maps.event.clearInstanceListeners(marker)
	marker = null;
}
// call this method to identify location from map using text data
// geocoder var is reqired and intitalised
function locateAddressonMap() {
	var mapOptions = {
		zoom : 8,
	};
	geocoder = new google.maps.Geocoder();
	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

	var address = document.getElementById('riForm:locId').value;
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			map.setCenter(results[0].geometry.location);

			marker = new google.maps.Marker({
				map : map,
				draggable : true,
				animation : google.maps.Animation.DROP,
				position : results[0].geometry.location
			});

			updateLocationDetails(results[0]);
			google.maps.event.addListener(marker, 'click', toggleBounce);
			google.maps.event
					.addListener(marker, 'dragend', updateLocationData);

		} else {
			alert('Geocode was not successful for the following reason: '
					+ status);
		}
	});
}

function updateLocationDetails(result) {
	document.getElementById('riForm:hidlat').value = marker.getPosition().lat();
	document.getElementById('riForm:hidlng').value = marker.getPosition().lng();
	document.getElementById('riForm:hidlct').value = result.geometry.location_type;

	var compoLength = result.address_components.length;
	for (var i = 0; i < compoLength; i++) {
		var arrayLength = result.address_components[i].types.length;
		for (var j = 0; j < arrayLength; j++) {
			var loc_type = "locality";
			var ct_type = "country";
			if (loc_type.localeCompare(result.address_components[i].types[j]) == 0) {
				document.getElementById('riForm:hidcty').value = result.address_components[i].long_name;
			}
			if (ct_type.localeCompare(result.address_components[i].types[j]) == 0) {
				document.getElementById('riForm:hidcnt').value = result.address_components[i].long_name;
			}
		}
	}
}
// Get location details from marker lat and long info
function updateLocationData() {

	document.getElementById('riForm:hidlat').value = marker.getPosition().lat();
	document.getElementById('riForm:hidlng').value = marker.getPosition().lng();
	var latlng = marker.getPosition();
	geocoder.geocode({
		'latLng' : latlng
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			if (results[0]) {

				// map.setZoom(11);
				// marker = new google.maps.Marker({
				// position: latlng,
				// map: map
				// });
				updateLocationDetails(results[0]);
				// infowindow.setContent(results[1].formatted_address);
				// infowindow.open(map, marker);
			} else {
				alert('No results found');
			}
		} else {
			alert('Geocoder failed due to: ' + status);
		}
	});

}
