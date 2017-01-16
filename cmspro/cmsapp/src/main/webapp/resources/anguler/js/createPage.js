$(document).ready(function(){
	
	$("#myTemplate").bind("click", function(event){
        var makeId = event.target.value;
        alert(makeId);
        
        if(makeId == '3col'){
        	$("#templatePreview").html("<div class='row full-border' style='height:76px;'>" +
					"<div class='col-sm-12'>Header</div>"+
					"</div>" +
					"<div class='row full-border' style='height:73px;'>" +
						"<div class='col-sm-4 text-center full-border'>" +
							"<h1>Hello</h1>" +
						"</div>" +
						"<div class='col-sm-4 text-center full-border''>" +
							"<h1>Hello</h1>" +
						"</div>" +
						"<div class='col-sm-4 text-center full-border''>" +
							"<h1>Hello</h1>" +
						"</div>" +
					"</div>" +
					"<div class='row full-border'style='height:76px;'  >" +
						"<div class='col-sm-12'>Footer</div>"+
					"</div>"
			);
        }
    });
	
});