var hostAddress="http://localhost:8989/cmsapp";
var getHostByName ="/admin/host/gethost/";
var getHosts = "/admin/host/gethosts"

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
        "columns": [
            { "data": "id" },
            { "data": "hostName" },
            { "data": "aliasName" }
        ]
    } );
	
});