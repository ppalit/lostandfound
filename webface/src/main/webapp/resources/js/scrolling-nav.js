//jQuery to collapse the navbar on scroll
$(window).scroll(function() {
	if ($(".navbar").offset().top > 50) {
		$(".navbar-fixed-top").addClass("top-nav-collapse");
	} else {
		$(".navbar-fixed-top").removeClass("top-nav-collapse");
	}
});

// jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {

	$('a.page-scroll').bind('click', function(event) {
		var $anchor = $(this);
		$('html, body').stop().animate({
			scrollTop : $($anchor.attr('href')).offset().top
		}, 1500, 'easeInOutExpo');
		event.preventDefault();
	});
});

// Initial load of page
$(document).ready(sizeContent);

// Every resize of window
$(window).resize(sizeContent);

// Dynamically assign height
function sizeContent() {
	var newHeight = $("html").height() + "px";
	var newGoogleMapHeight = $("html").height() / 2 + "px"
	$(".myCarousel").css("height", newHeight);
	$(".google-map").css("height", newGoogleMapHeight);
}

$(document).ready(function() {

	$('.datePicker').datepicker({
		format : "dd/mm/yyyy",
		autoclose : "true"
	});

});

// Code for google maps integration

var map;

function initialize() {
	var mapOptions = {
		zoom : 8,
		// pass this data to load a page with default cordinates
		center : new google.maps.LatLng(-34.397, 150.644)
	};
	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

}
google.maps.event.addDomListener(window, 'load', initialize);

//call this method to find current location
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
			//			});
			
			map.setCenter(pos);
			
			marker = new google.maps.Marker({
			    map:map,
			    draggable:true,
			    animation: google.maps.Animation.DROP,
			    position: pos
			  });
			  google.maps.event.addListener(marker, 'click', toggleBounce);
			  
		}, function() {
			handleNoGeolocation(true);
		});
	} else {
		// Browser doesn't support Geolocation
		handleNoGeolocation(false);
	}

//handles error if at the time of selection
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

//function for toggle
function toggleBounce() {

	  if (marker.getAnimation() != null) {
	    marker.setAnimation(null);
	  } else {
	    marker.setAnimation(google.maps.Animation.BOUNCE);
	  }
	}
