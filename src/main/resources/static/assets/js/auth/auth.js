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
			 data : {email : Auth.getMail()},
			 success: function(res) {				
			     if (res.mensage == 'Error') { 	 
			    	 Auth.setMensage('Error', 'E-mail não encontrado.');
			     } else {
			    	 Auth.setMensage('Success', 'Senha enviada para e-mail acima.');
			     }
			 },
			 error: function() { 
				 Auth.setMensage('Error', 'Houve um problema ao enviar sua solicitação de senha.'); 			
			 }
		 });
		 
	 },
	 setMensage : function(type, text) {
		 
		 var typem = (type != 'Success' ? 'danger' : 'success');
		 $('#return_mensage').text('');
		 $('#return_mensage').removeClass();
		 $('#return_mensage').addClass('alert alert-'+ typem);
		 $('#return_mensage').append("<b>"+ type  +"!</b> " + text);
		 $('#return_mensage').show();
	 }
		
}
$(Auth.init)