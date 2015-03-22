/**
 * 
 */

// Initial load of page
$(document).ready(initialize);

var placeSearch, autocomplete;


function initialize() {
  // Create the autocomplete object, restricting the search
  // to geographical location types.
  autocomplete = new google.maps.places.Autocomplete(
      /** @type {HTMLInputElement} */(document.getElementById('hm:slID')),
      { types: ['geocode'] });
  // When the user selects an address from the dropdown,
  // populate the address fields in the form.
  google.maps.event.addListener(autocomplete, 'place_changed', function() {
    fillInAddress();
  });
}



//[START region_fillform]
function fillInAddress() {
// Get the place details from the autocomplete object.
var place = autocomplete.getPlace();


// Get each component of the address from the place details
// and fill the corresponding field on the form.
//for (var i = 0; i < place.address_components.length; i++) {
// var addressType = place.address_components[i].types[0];
// if (componentForm[addressType]) {
//   var val = place.address_components[i][componentForm[addressType]];
//   document.getElementById(addressType).value = val;
// }
//}
}


//[START region_geolocation]
//Bias the autocomplete object to the user's geographical location,
//as supplied by the browser's 'navigator.geolocation' object.
function geolocate() {
if (navigator.geolocation) {
 navigator.geolocation.getCurrentPosition(function(position) {
   var geolocation = new google.maps.LatLng(
       position.coords.latitude, position.coords.longitude);
   var circle = new google.maps.Circle({
     center: geolocation,
     radius: position.coords.accuracy
   });
   autocomplete.setBounds(circle.getBounds());
 });
}
}
//[END region_geolocation]
