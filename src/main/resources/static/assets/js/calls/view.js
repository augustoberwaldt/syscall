var View = {
		
     init : function() { 
    	
    	 $('#submitComment').click(View.submitForm);
    	 CKEDITOR.replace('editor1');
     },
     submitForm : function() { 
    	 var responsavel  = parseInt($('#responsavel').val());

    	 if (!responsavel) {
	    	 swal({
	    		  title: "Atenção",
	    		  text: "Deseja se tornar agente do chamado ?",
	    		  type: "warning",
	    		  showCancelButton: true,
	    		  confirmButtonColor: "#5cb85c",
	    		  confirmButtonText: "Sim",
	    		  cancelButtonText: "Não",
	    		  closeOnConfirm: true,
	    		  closeOnCancel: true
	    		}, function(isConfirm) {
	    			 if (isConfirm) {
	    				 $('#agente').val("1");
	    			 } 
	    			 
	    			 $('#formComment').submit();
	    		});
	      } else {
	    	  $('#formComment').submit();
	      }
        
     }	
		
};

$(View.init);