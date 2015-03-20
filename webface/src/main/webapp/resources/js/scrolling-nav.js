//jQuery to collapse the navbar on scroll
$(window).scroll(function() {
	if ($(".navbar").offset().top > 50) {
		$(".navbar-fixed-top").addClass("top-nav-collapse");
	} else {
		$(".navbar-fixed-top").removeClass("top-nav-collapse");
	}
});

//for side panel in result screen
$(document).ready(function() {
	  $('[data-toggle=offcanvas]').click(function() {
	    $('.row-offcanvas').toggleClass('active');
	  });
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

/**
 * Response callback for when the API client receives a response.
 *
 * @param resp The API response object with the user email and profile information.
 */
function handleEmailResponse(resp) {
  var primaryEmail;
  console.log(resp);
  console.log(resp.emails.length);
  
  for(var i = 0 ; i < resp.emails.length; i++){
  	if(resp.emails[i].type == "account"){
  		if(document.getElementById('riForm:emlId')!= null){
  		document.getElementById('riForm:emlId').value = resp.emails[i].value;
  		}
  	}
  }
  
  if(resp.displayName!=null){
	  if(document.getElementById('riForm:unId')!= null){
  	document.getElementById('riForm:unId').value = resp.displayName;
	  }
  }
  


}


