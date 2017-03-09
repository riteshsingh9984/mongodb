var app = angular.module("myApp", []);
app.directive("w3TestDirective", function() {
    return {
        template : "I was made in a directive constructor!"
    };
});
var count = 1;
$(document).ready(function(){
	
	/*Adding Container in Template*/
	$(".addtemplateContainer").bind("click", function(event){
        var makeId = ((event.target.id).substring(0,(event.target.id).indexOf("btn")))+"template";
        $("#"+makeId).prepend("<div class='row' id='"+count+"content'>" +
        			"<div class='col-sm-12 full-border'>" +
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
		   
		});
	
	/*Make view in adminMode*/
	$( document ).on( 'click', '#adminModeAction', function(event) {
		   $( ".rmadmin").show();
		});
	
});