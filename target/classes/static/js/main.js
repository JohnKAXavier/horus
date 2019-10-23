/**
 * 
 */

$(document).ready(function() {

	$('.graph ').submit( function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
				
		
		
		$.get(href, function(dados,status){
		    console.log(country);
			$('#severidade').val(dados.severidade);
			$('#percentualPreenchimento').val(dados.percentualPreenchimento);
			
		});
		$("strong").append("<b>" + severidade + "</b>");

		
	});
	
	
	
	
})