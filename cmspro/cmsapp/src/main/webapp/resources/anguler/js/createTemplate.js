var app = angular.module("myApp", []);
app.directive("w3TestDirective", function() {
    return {
        template : "I was made in a directive constructor!"
    };
});
var count = 1;
var rowsCount = 0;
$(document).ready(function(){
	
	$( "#addCols").hide();
	$( "#act").hide();
	
	/*Column Select-Box*/
	$( document ).on( 'click', '#addRows', function(event) {
		   $( "#addCols").show();
		});
	
	
	/*Column Select-Box Apply*/
	$( document ).on( 'click', '#addRowsCols', function(event) {
		rowsCount++;   
		
		$( "#addCols").hide();
		$( "#act").hide();
		
		if($("#colId").val() == '100%'){
		
			var counter = rowsCount;
			$("#tpb").append('<div id="'+colCounter1+'removebtn" class="row  rmadmin text-center">' +
								'<br/><div id="'+colCounter1+'remove" class="removeclass btn btn-sm btn-danger rmadmin ">Remove-Row</div>'+
							 '</div>'+
								'<div id="'+colCounter1+'container" class="row full-border text-center" >' +
								'<div id="'+counter+'template" class="col-sm-12 text-center " >'+
								  		'<div id="'+counter+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
								  	'</div>'+
								  '</div>');
		}
		
		if($("#colId").val() == '33%-66%'){
			
			var colCounter1 = rowsCount;
			rowsCount++;
			var colCounter2 = rowsCount;
			$("#tpb").append('<div id="'+colCounter1+'removebtn" class="row  rmadmin text-center">' +
								'<br/><div id="'+colCounter1+'remove" class="removeclass btn btn-sm btn-danger rmadmin ">Remove-Row</div>'+
							 '</div>'+
							 '<div id="'+colCounter1+'container" class="row full-border text-center" >' +
								'<div id="'+colCounter1+'template" class="col-sm-4 text-center right-border" >'+
								  		'<div id="'+colCounter1+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
								  	'</div>'+
								  	'<div id="'+colCounter2+'template" class="col-sm-8 text-center " >'+
							  			'<div id="'+colCounter2+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
							  		'</div>'+
							  '</div>');
		}
		
		if($("#colId").val() == '66%-33%'){
			
			var colCounter1 = rowsCount;
			rowsCount++;
			var colCounter2 = rowsCount;
			$("#tpb").append('<div id="'+colCounter1+'removebtn" class="row  rmadmin text-center">' +
								'<br/><div id="'+colCounter1+'remove" class="removeclass btn btn-sm btn-danger rmadmin ">Remove-Row</div>'+
							 '</div>'+
								'<div id="'+colCounter1+'container" class="row full-border text-center" >' +
								'<div id="'+colCounter1+'template" class="col-sm-8 text-center right-border" >'+
								  		'<div id="'+colCounter1+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
								  	'</div>'+
								  	'<div id="'+colCounter2+'template" class="col-sm-4 text-center " >'+
							  			'<div id="'+colCounter2+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
							  		'</div>'+
							  '</div>');
			
		}
		
		if($("#colId").val() == '33%-33%-33%'){
			
			var colCounter1 = rowsCount;
			rowsCount++;
			var colCounter2 = rowsCount;
			rowsCount++;
			var colCounter3 = rowsCount;
			
			$("#tpb").append('<div id="'+colCounter1+'removebtn" class="row  rmadmin text-center">' +
							'<br/><div id="'+colCounter1+'remove" class="removeclass btn btn-sm btn-danger rmadmin ">Remove-Row</div>'+
						     '</div>'+
								'<div id="'+colCounter1+'container" class="row full-border text-center" >' +
								'<div id="'+colCounter1+'template" class="col-sm-4 text-center right-border" >'+
								  		'<div id="'+colCounter1+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
								  	'</div>'+
								  	'<div id="'+colCounter2+'template" class="col-sm-4 text-center right-border" >'+
							  			'<div id="'+colCounter2+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
							  		'</div>'+
							  		'<div id="'+colCounter3+'template" class="col-sm-4 text-center" >'+
						  				'<div id="'+colCounter3+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
						  			'</div>'+
							  '</div>');
			
		}
		
		if($("#colId").val() == '25-75%'){
			
			var colCounter1 = rowsCount;
			rowsCount++;
			var colCounter2 = rowsCount;
			$("#tpb").append('<div id="'+colCounter1+'removebtn" class="row  rmadmin text-center">' +
								'<br/><div id="'+colCounter1+'remove" class="removeclass btn btn-sm btn-danger rmadmin ">Remove-Row</div>'+
							     '</div>'+
								'<div id="'+colCounter1+'container" class="row full-border text-center" >' +
								'<div id="'+colCounter1+'template" class="col-sm-3 text-center right-border" >'+
								  		'<div id="'+colCounter1+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
								  	'</div>'+
								  	'<div id="'+colCounter2+'template" class="col-sm-9 text-center " >'+
							  			'<div id="'+colCounter2+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
							  		'</div>'+
							  '</div>');
		}
		
		if($("#colId").val() == '75%-25%'){
			
			var colCounter1 = rowsCount;
			rowsCount++;
			var colCounter2 = rowsCount;
			$("#tpb").append('<div id="'+colCounter1+'removebtn" class="row  rmadmin text-center">' +
							'<br/><div id="'+colCounter1+'remove" class="removeclass btn btn-sm btn-danger rmadmin ">Remove-Row</div>'+
						     '</div>'+
								'<div id="'+colCounter1+'container" class="row full-border text-center" >' +
								'<div id="'+colCounter1+'template" class="col-sm-9 text-center right-border" >'+
								  		'<div id="'+colCounter1+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
								  	'</div>'+
								  	'<div id="'+colCounter2+'template" class="col-sm-3 text-center " >'+
							  			'<div id="'+colCounter2+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
							  		'</div>'+
							  '</div>');
		}
		
		if($("#colId").val() == '50%-50%'){
			
			var colCounter1 = rowsCount;
			rowsCount++;
			var colCounter2 = rowsCount;
			$("#tpb").append('<div id="'+colCounter1+'removebtn" class="row  rmadmin text-center">' +
								'<br/><div id="'+colCounter1+'remove" class="removeclass btn btn-sm btn-danger rmadmin ">Remove-Row</div>'+
						     '</div>'+
							 '<div id="'+colCounter1+'container" class="row full-border text-center" >' +
								  	'<div id="'+colCounter1+'template" class="col-sm-6 text-center right-border" >'+
								  		'<div id="'+colCounter1+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
								  	'</div>'+
								  	'<div id="'+colCounter2+'template" class="col-sm-6 text-center " >'+
							  			'<div id="'+colCounter2+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
							  		'</div>'+
							  '</div>');
			
		}
		
		if($("#colId").val() == '25%-25%-25%-25%'){
			
			var colCounter1 = rowsCount;
			rowsCount++;
			var colCounter2 = rowsCount;
			rowsCount++;
			var colCounter3 = rowsCount;
			rowsCount++;
			var colCounter4 = rowsCount;
			
			$("#tpb").append('<div id="'+colCounter1+'removebtn" class="row  rmadmin text-center">' +
								'<br/><div id="'+colCounter1+'remove" class="removeclass btn btn-sm btn-danger rmadmin ">Remove-Row</div>'+
					          '</div>'+
							  '<div id="'+colCounter1+'container" class="row full-border text-center text-center" >' +
								  	'<div id="'+colCounter1+'template" class="col-sm-3 text-center bottom-border right-border" >'+
								  		'<div id="'+colCounter1+'btn" class="btn btn-sm btn-info  rmadmin addtemplateContainer">Add-container</div>'+
								  	'</div>'+
								  	'<div id="'+colCounter2+'template" class="col-sm-3 text-center bottom-border right-border" >'+
							  			'<div id="'+colCounter2+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
							  		'</div>'+
							  		'<div id="'+colCounter3+'template" class="col-sm-3 text-center bottom-border right-border" >'+
						  				'<div id="'+colCounter3+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
						  			'</div>'+
						  			'<div id="'+colCounter4+'template" class="col-sm-3 text-center bottom-border " >'+
					  					'<div id="'+colCounter4+'btn" class="btn btn-sm btn-info rmadmin addtemplateContainer">Add-container</div>'+
					  				'</div>'+
							  '</div>');
			
		}
		
		
		}); 
	
	/*Make view in adminMode*/
	$( document ).on( 'click', '.removeclass', function(event) {
		var makeId = ((event.target.id).substring(0,(event.target.id).indexOf("remove")))+"container";
		$("#"+makeId).remove();
		
		makeId = ((event.target.id).substring(0,(event.target.id).indexOf("remove")))+"removebtn";
		$("#"+makeId).remove();
		});
	
	/*Adding Container in Template*/
	/*$(".addtemplateContainer").bind("click", function(event){*/
	$( document ).on( 'click', '.addtemplateContainer', function(event) {
        var makeId = ((event.target.id).substring(0,(event.target.id).indexOf("btn")))+"template";
        $("#"+makeId).append("<div class='row' id='"+count+"content'>" +
        			"<div class='col-sm-12 bottom-border'>" +
        				"<div class='rmadmin'>" +
	        				"<div class='row'>" +
	        					"<div class='col-sm-6'>" +
	        						"<select id='"+count+"chooseElement' class='form-control choose-element'>" +
		        						"<option>Lebel</option>" +
		        						"<option>Pargraph</option>" +
		        						"<option>Image</option>" +
		        						"<option>Slide</option>" +
		        						"<option>Ritch-Text</option>"+
	        						"</select>" +
	        					"</div>" +
	        					"<div class='col-sm-6 text-right'>" +
	        						"<div id='"+count+"contentRemoveAction' class='contentRemoveAction btn btn-sm btn-danger glyphicon glyphicon-remove'></div>" +
	        					"</div>" +
	        				"</div>" +
	        				"<div id='"+count+"selectBox' class='row'>" +
	        				"</div>" +
	        			"</div>" +
        				"<div id='"+count+"contentElement'><h1>HellO</h1></div>" +
        			"</div>" +
        		"</div>");
        count++ ;
    });
	
	/*Removing Container From Template*/
	$( document ).on( 'click', '.contentRemoveAction', function(event) {
		var makeId = ((event.target.id).substring(0,(event.target.id).indexOf("contentRemoveAction")))+"content";
		   $( "#"+makeId ).remove();
		});
	
	/*Adding Container From Template*/
	$( document ).on( 'click', '.contentAddAction', function(event) {
		var makeId = ((event.target.id).substring(0,(event.target.id).indexOf("contentAddAction")))+"content";
		   alert("It's works"+makeId);
		   
		   $("#"+makeId).append("<div>Cool</div>");
		   
		});
	
	/*Choose element from select-Box for template-content*/
	$( document ).on( 'click', '.choose-element', function(event) {
		var makeId = ((event.target.id).substring(0,(event.target.id).indexOf("chooseElement")))+"contentElement";  
		var makeValue = event.target.value;
		var idData = ((event.target.id).substring(0,(event.target.id).indexOf("chooseElement")));
		$('#'+makeId).html('<h3>cool..!<h3>');
		var selectId = ((event.target.id).substring(0,(event.target.id).indexOf("chooseElement")))+"selectBox";
		
		if(event.target.value == 'Pargraph'){
			var selectDataId = idData+"selectBox";
			$("#"+selectDataId).show();
			
			$('#'+selectId).html("<div class='col-sm-10 full-border'>" +
					"<div id='"+idData+"selectBoxElement' >" +
							"<textarea id='"+idData+"elementData' rows='4' cols='50'>"+
							"Enter text here...</textarea>" +
					"</div>" +
					"</div>" +
					"<div class='col-sm-2'>" +
						"<div id='"+idData+"selectBoxApply' class='selectBoxApply btn btn-sm btn-warning'>Apply</div>" +
					"</div>");
			}
		});
	
	/*Select-Box Apply button*/
	$( document ).on( 'click', '.selectBoxApply', function(event) {
		var selectBoxId = ((event.target.id).substring(0,(event.target.id).indexOf("selectBoxApply")))+"selectBox";
		var elementDataId = ((event.target.id).substring(0,(event.target.id).indexOf("selectBoxApply")))+"elementData";
		var contentElementId = ((event.target.id).substring(0,(event.target.id).indexOf("selectBoxApply")))+"contentElement";
		
		$('#'+contentElementId).html($("#"+elementDataId).val());
		$("#"+selectBoxId).html('');
		});
	
	/*Make view in userMode*/
	$( document ).on( 'click', '#userModeAction', function(event) {
		   $( ".rmadmin").hide();
		});
	
	/*Get Pure Html*/
	$( document ).on( 'click', '#getHtmlAction', function(event) {
		  
		   $('#myHtml').val($('#templateBody').html());
		   $('#myHtmlView').text($('#templateBody').html());
		});
	
	/*Make view in adminMode*/
	$( document ).on( 'click', '#adminModeAction', function(event) {
		   $( ".rmadmin").show();
		});
	
	/*copy snippet html code*/
	$( document ).on( 'click', '#btncopy', function(event) {
		   
		var $temp = $("<input>");
		  $("body").append($temp);
		  $temp.val($("#myHtmlView").text()).select();
		  document.execCommand("copy");
		  $temp.remove();
	});
	
	/*Demo*/
	$('#lstFruits').multiselect({
        includeSelectAllOption: true
    });
	
	$( document ).on( 'change', '#lstFruits', function(event) {
		var selected = $("#lstFruits option:selected");
        var message = "";
        selected.each(function () {
            /*message += $(this).text() + "," + $(this).val() + "\n";*/
        	message += $(this).text() + ",";
        });
        alert(message);
        message = message.substring(0,message.length - 1)
        
        alert(message);
        
        $("#dataText").val(message);
        
		});
	
});