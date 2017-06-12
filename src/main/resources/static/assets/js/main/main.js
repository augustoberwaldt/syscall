var Main = {
		
	 init : function () {
           $('#nav-accordion li').each(function(index,value){
                 var a  = $(value).find('a');
           	     var link = a.attr('href');
           	     if (link== window.document.location.pathname) {
                     a.addClass('active');
				 }
		   });
	 }

		
}
$(Main.init)