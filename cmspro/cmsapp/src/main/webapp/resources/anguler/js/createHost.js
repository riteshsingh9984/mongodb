//var hostAddress="http://209.200.39.254:8989/cmsapp";
var hostAddress="http://localhost:8989/cmsapp";
var getHostByName ="/admin/host/gethost/";
var getHosts = "/admin/host/gethosts";
var pageCreate = "/admin/page/create/";
var pageList = "/admin/page/get-pages/";
var headerFooterAdd = "/admin/host/create-header-footer/";
var headerDesign = "/admin/host/header-design/";
var footerDesign = "/admin/host/footer-design/";
var hostLaunch = "/admin/host/launch/";
var hostLaunchDown = "/admin/host/launch-down/";
	

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
		  
		});
	return resultData;
}

function hello(){
	
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
        "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
        	if ( aData.isHeader && aData.isFooter && (aData.pages.length != 0) ){
        		if(!aData.hostLaunchConfig.isActive){
        			// Host Active
        			$('td', nRow).css('background-color', '#F7DC6F');
            	}else{
            		// Host InActive
            		$('td', nRow).css('background-color', '#82E0AA'); 
            	}
            }else{
            	// Host Not ready for Active
            	$('td', nRow).css('background-color', '#F1948A');
            }
        },
        "columns": [
            { "data": "id" },
            { "data": "hostName" },
            { "data": "aliasName" },
            { "data": "pages",
              "render": function ( data, type, full, meta ) {
          	      return '<a href="'+hostAddress+pageList+full.hostName+'">'+(data.length!=null ?data.length:0)+'</a>&nbsp;&nbsp;&nbsp;&nbsp;';
          	    }	
            },
            { "data": "isHeader",
                "render": function ( data, type, full, meta ) {
                	
	                	if(data){
	                		return '<a title="Edit Site" href="'+hostAddress+headerDesign+full.hostName+'" class="glyphicon glyphicon-pencil"></a>&nbsp;&nbsp;&nbsp;&nbsp;';
	                	}else{
	                		
	                		return '<a title="Create Header" href="'+hostAddress+headerFooterAdd+full.hostName+'" class="glyphicon glyphicon-plus-sign"></a>&nbsp;&nbsp;&nbsp;&nbsp;'
	                	}
            	    }	
              },
            { "data": "isFooter",
                  "render": function ( data, type, full, meta ) {
                	  if(data){
	                		return '<a title="Edit Site" href="'+hostAddress+footerDesign+full.hostName+'" class="glyphicon glyphicon-pencil"></a>&nbsp;&nbsp;&nbsp;&nbsp;';
	                	}else{
	                		return '<a title="Create Footer" href="'+hostAddress+headerFooterAdd+full.hostName+'" class="glyphicon glyphicon-plus-sign"></a>&nbsp;&nbsp;&nbsp;&nbsp;'
	                	}
              	    }	
                },
            { "data": "hostLaunchConfig.isActive",
                    "render": function ( data, type, full, meta ) {
	                  	  if(full.isHeader && full.isFooter && (full.pages.length != 0)){
	  	                		if(!data){
	  	                			return '<a title="Edit Site" href="'+hostAddress+hostLaunch+full.hostName+'" class="glyphicon glyphicon-hand-up"></a>&nbsp;&nbsp;&nbsp;&nbsp;';
	  	                		}else{
	  	                			
	  	                			return '<a title="Edit Site" href="'+hostAddress+hostLaunchDown+full.hostName+'" class="glyphicon glyphicon-hand-down"></a>&nbsp;&nbsp;&nbsp;&nbsp;';
	  	                		}
	  	                	}else{
	  	                		return "Not";
	  	                	}
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