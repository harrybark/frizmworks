/**
 * 
 */

$(document).ready(
		function() { 	jQuery(".shop_Contents").hide();

			$('.shop').click(	function() {
						$('.shop_Contents').not($(this).next('.shop_Contents').slideToggle(500)).slideUp();
					});

		});