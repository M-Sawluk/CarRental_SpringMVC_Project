$(document).ready(function() {
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
    

	  $('#searchbutton').click(function() {

		  var url='/carRental/carrent/';
		  
		  	if($('#min').val()!=0 || $('#max').val()!=0 )
		  		{
		  		url+='ByCriteria;'
		  		}
		  	if($('#min').val()!=0)
	  		{
	  		url+='low='+$('#min').val()+';'
	  		}
		  	if($('#max').val()!=0)
	  		{
	  		url+='high='+$('#max').val()+';'
	  		}
		  
			window.location.href=url +'search?name='+$('#search').val();

	  });
});




