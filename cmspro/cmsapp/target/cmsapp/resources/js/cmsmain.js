/**
 * 
 */
$(function() {
		$('input[type="checkbox"]')
				.on(
						'change',
						function() {
							$('input.checkbox').not(this).prop('checked', false);  

							if (this.id == 'header1_check') {
								var html = document.getElementById('header1').innerHTML;
								document.getElementById('content_hidden').value = html;
							} else if (this.id == 'header2_check') {
								var html = document.getElementById('header2').innerHTML;
								document.getElementById('content_hidden').value = html;
							} else if (this.id == 'header3_check') {
								var html = document.getElementById('header3').innerHTML;
								document.getElementById('content_hidden').value = html;
							} else if (this.id == 'header3_check') {
								var html = document.getElementById('header3').innerHTML;
								document.getElementById('content_hidden').value = html;
							} else if (this.id == 'leftsidebar1_check') {
								var html = document.getElementById('leftsidebar1').innerHTML;
								document.getElementById('leftsidebarcontent_hidden').value = html;
							} else if (this.id == 'leftsidebar2_check') {
								var html = document.getElementById('leftsidebar2').innerHTML;
								document.getElementById('leftsidebarcontent_hidden').value = html;
							} else if (this.id == 'leftsidebar3_check') {
								var html = document.getElementById('leftsidebar3').innerHTML;
								document.getElementById('leftsidebarcontent_hidden').value = html;
							} else if (this.id == 'rightsidebar1_check') {
								var html = document.getElementById('rightsidebar1').innerHTML;
								document.getElementById('rightsidebarcontent_hidden').value = html;
							} else if (this.id == 'rightsidebar2_check') {
								var html = document.getElementById('rightsidebar2').innerHTML;
								document.getElementById('rightsidebarcontent_hidden').value = html;
							} else if (this.id == 'rightsidebar3_check') {
								var html = document.getElementById('rightsidebar3').innerHTML;
								document.getElementById('rightsidebarcontent_hidden').value = html;
							} else if (this.id == 'footer1_check') {
								var html = document.getElementById('footer1').innerHTML;
								document.getElementById('footercontent_hidden').value = html;
							} else if (this.id == 'footer2_check') {
								var html = document.getElementById('footer2').innerHTML;
								document.getElementById('footercontent_hidden').value = html;
							} else if (this.id == 'footer3_check') {
								var html = document.getElementById('footer3').innerHTML;
								document.getElementById('footercontent_hidden').value = html;
							}
						});
	});
	
	
	$(document).ready(
	        function() {
	            $('#header-form').submit(
	                    function(e) {
	                        var frm = $('#header-form');
	                        e.preventDefault();

	                        var data = {}
	                        var Form = this;
	                        
	                        //Gather Data also remove undefined keys(buttons)
	                        $.each(this, function(i, v) {
	                            var input = $(v);
	                            data[input.attr("name")] = input.val();
	                            delete data["undefined"];
	                        });
	                        
	                        $.ajax({
	                        	contentType : 'application/json; charset=utf-8',
	                        	  type: "POST",
	                        	  url: frm.attr('action'),
	                        	  data: JSON.stringify(data),
	                        	  cache: false,
	                        	  success: function(data){
	                        	     if(data == true){
	                        	    	 $('#myModal').modal('hide');
	                        	     }
	                        	  }
	                        	});
	                    });
	            
	            $('#leftsidebar-form').submit(
	                    function(e) {
	                        var frm = $('#leftsidebar-form');
	                        e.preventDefault();

	                        var data = {}
	                        var Form = this;
	                        
	                        //Gather Data also remove undefined keys(buttons)
	                        $.each(this, function(i, v) {
	                            var input = $(v);
	                            data[input.attr("name")] = input.val();
	                            delete data["undefined"];
	                        });
	                        
	                        $.ajax({
	                        	contentType : 'application/json; charset=utf-8',
	                        	  type: "POST",
	                        	  url: frm.attr('action'),
	                        	  data: JSON.stringify(data),
	                        	  cache: false,
	                        	  success: function(data){
	                        	     if(data == true){
	                        	    	 $('#myModalleft').modal('hide');
	                        	     }
	                        	  }
	                        	});
	                    });
	            
	            $('#rightsidebar-form').submit(
	                    function(e) {
	                        var frm = $('#rightsidebar-form');
	                        e.preventDefault();

	                        var data = {}
	                        var Form = this;
	                        
	                        //Gather Data also remove undefined keys(buttons)
	                        $.each(this, function(i, v) {
	                            var input = $(v);
	                            data[input.attr("name")] = input.val();
	                            delete data["undefined"];
	                        });
	                        
	                        $.ajax({
	                        	contentType : 'application/json; charset=utf-8',
	                        	  type: "POST",
	                        	  url: frm.attr('action'),
	                        	  data: JSON.stringify(data),
	                        	  cache: false,
	                        	  success: function(data){
	                        	     if(data == true){
	                        	    	 $('#myModalright').modal('hide');
	                        	     }
	                        	  }
	                        	});
	                    });
	            
	            $('#footer-form').submit(
	                    function(e) {
	                        var frm = $('#footer-form');
	                        e.preventDefault();

	                        var data = {}
	                        var Form = this;
	                        
	                        //Gather Data also remove undefined keys(buttons)
	                        $.each(this, function(i, v) {
	                            var input = $(v);
	                            data[input.attr("name")] = input.val();
	                            delete data["undefined"];
	                        });
	                        
	                        $.ajax({
	                        	contentType : 'application/json; charset=utf-8',
	                        	  type: "POST",
	                        	  url: frm.attr('action'),
	                        	  data: JSON.stringify(data),
	                        	  cache: false,
	                        	  success: function(data){
	                        	     if(data == true){
	                        	    	 $('#myModalfooter').modal('hide');
	                        	     }
	                        	  }
	                        	});
	                    });
	            
	            $('#editheader').click(function(){
	                alert("editable");
	             });
	        });