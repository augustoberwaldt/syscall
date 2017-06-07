var Auth = {
		
	 init : function () {
		 $('#envRec').click(Auth.sendRequestRemember);
	 },
	 getMail : function () {
		 return $('#emailRec').val();
	 },
	 sendRequestRemember : function () {
		 $.ajax({
			 url : '/rememberPassword', 
			 method: 'POST',
			 data : {email : Auth.getMail()}
		 });
		 
		 
	 }
		
}
$(Auth.init)