var hostAddress="http://localhost:8989/cmsapp";
var getPages = "/admin/page/getpages/";

function ajaxCallGet(url,method){
	
	var resultData;
	var request = $.ajax({
		  url: url,
		  type: method,
		  async: false,
		  cache: false,
		  timeout: 30000,
		  dataType: "html"
		});

		request.done(function(msg) {
		  resultData = msg;
		});
		
		request.fail(function(jqXHR, textStatus) {
		  alert( "Request failed: " + textStatus );
		});
	return resultData;
}

function ajaxCallPost(url,method,data){
	
	var resultData;
	var request = $.ajax({
		  url: url,
		  type: method,
		  data : data,
		  async: false,
		  cache: false,
		  timeout: 30000,
		  dataType: "html"
		});

		request.done(function(msg) {
		  resultData = msg;
		});
		
		request.fail(function(jqXHR, textStatus) {
		  alert( "Request failed: " + textStatus );
		});
	return resultData;
}	

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
	
	
	$('#example').DataTable( {
        "ajax": hostAddress+getPages+$("#myHost").val(),
        "columns": [
            { "data": "pageName" },
            { "data": "templateName" },
            { "data": "editableInfo.createdBy" },
            { "data": "editableInfo.createdAt",
              "render": function ( data, type, full, meta ) {
            	      return new Date(data).toLocaleString();
            	    }
            },
            { "data": "pageName",
                "render": function ( data, type, full, meta ) {
              	      return '<a title="Edit Site" href="'+data+'" class="glyphicon glyphicon-pencil"></a>&nbsp;&nbsp;&nbsp;&nbsp;'+
              	      		 '<a title="View Site" href="'+data+'" class="glyphicon glyphicon-eye-open"></a>&nbsp;&nbsp;&nbsp;&nbsp;';
              	    } 	
              }
        ]
    } );
	
});