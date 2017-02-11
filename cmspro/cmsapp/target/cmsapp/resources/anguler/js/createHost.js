var hostAddress="http://localhost:8989/cmsapp";
var getHostByName ="/admin/host/gethost/";
var getHosts = "/admin/host/gethosts";
var pageCreate = "/admin/page/create/"
var pageList = "/admin/page/get-pages/"	
	

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
    
	$("#hostName").blur(function(event){
		var yourHost = event.target.value;
        var tool = ajaxCallGet(hostAddress+getHostByName+event.target.value,"GET");
        if(tool == 'FOUND'){
        	$( "#hostName" ).val('');
        	$("#hostName").attr("placeholder", yourHost+" not available..! ");
        	$('#hostName').addClass('placeholder-color');
        }
    });
	
	$('#example').DataTable( {
        "ajax": hostAddress+getHosts,
        "pageLength": 8,
        "columns": [
            { "data": "id" },
            { "data": "hostName" },
            { "data": "aliasName" },
            { "data": "pages",
              "render": function ( data, type, full, meta ) {
          	      return '<a href="'+hostAddress+pageList+full.hostName+'">'+(data.length!=null ?data.length:0)+'</a>&nbsp;&nbsp;&nbsp;&nbsp;';
          	    }	
            },
            { "data": "editableInfo.createdBy" },
            { "data": "editableInfo.createdAt",
              "render": function ( data, type, full, meta ) {
            	      return new Date(data).toLocaleString();
            	    }
            },
            { "data": "hostName",
                "render": function ( data, type, full, meta ) {
              	      return '<a title="Add New Page" href="'+hostAddress+pageCreate+data+'" class="glyphicon glyphicon-plus-sign"></a>&nbsp;&nbsp;&nbsp;&nbsp;'+
              	      		 '<a title="Edit Site" href="'+data+'" class="glyphicon glyphicon-pencil"></a>&nbsp;&nbsp;&nbsp;&nbsp;'+
              	      		 '<a title="View Site" href="'+data+'" class="glyphicon glyphicon-eye-open"></a>&nbsp;&nbsp;&nbsp;&nbsp;';
              	    } 	
              },
        ]
    } );
	
});