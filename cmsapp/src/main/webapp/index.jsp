
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<script type="text/javascript" src="resources/js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.7.2.custom.min.js"></script>
<link rel="Stylesheet" type="text/css" href="resources/css/jqueryui/ui-lightness/jquery-ui-1.7.2.custom.css" />

<script type="text/javascript" src="resources/js/jHtmlArea-0.7.5.js"></script>
<link rel="Stylesheet" type="text/css" href="resources/css/jHtmlArea.css" />

</head>
<body>
	<script type="text/javascript">    
        // You can do this to perform a global override of any of the "default" options
        // jHtmlArea.fn.defaultOptions.css = "jHtmlArea.Editor.css";

        $(function() {
           // $("textarea").htmlarea(); // Initialize all TextArea's as jHtmlArea's with default values

            $("#txtDefaultHtmlArea").htmlarea(); // Initialize jHtmlArea's with all default values

              $("#txtCustomHtmlArea").htmlarea({
                // Override/Specify the Toolbar buttons to show
                toolbar: [
                    ["html"],
                    ["bold","italic", "underline", "|", "forecolor"],
                    ["p", "h1", "h2", "h3", "h4", "h5", "h6"],
                    ["link", "unlink", "|", "image"],                    
                    [{
                        // This is how to add a completely custom Toolbar Button
                        css: "custom_disk_button",
                        text: "Save",
                        action: function(btn) {
                            // 'this' = jHtmlArea object
                            // 'btn' = jQuery object that represents the <A> "anchor" tag for the Toolbar Button
                            alert('SAVE!\n\n' + this.toHtmlString());
                        }
                    }]
                ],

                // Override any of the toolbarText values - these are the Alt Text / Tooltips shown
                // when the user hovers the mouse over the Toolbar Buttons
                // Here are a couple translated to German, thanks to Google Translate.
                toolbarText: $.extend({}, jHtmlArea.defaultOptions.toolbarText, {
                        "bold": "fett",
                        "italic": "kursiv",
                        "underline": "unterstreichen"
                    }),

                // Specify a specific CSS file to use for the Editor
                css: "style//jHtmlArea.Editor.css",

                // Do something once the editor has finished loading
                loaded: function() {
                    //// 'this' is equal to the jHtmlArea object
                    //alert("jHtmlArea has loaded!");
                    //this.showHTMLView(); // show the HTML view once the editor has finished loading
                }
            });
        });
    </script>

	<textarea id="txtDefaultHtmlArea" cols="50" rows="15"><p>
	   <h3>Test H3</h3>This is some sample text to test out the <b>WYSIWYG Control</b>.</p></textarea>
	<br />
	<hr />
	<br />

	<script type="text/javascript">
        $(function() {
            $("#btnRemoveCustomHtmlArea").click(function() {
                $("#txtCustomHtmlArea").htmlarea("dispose");
            });
        });
    </script>


	<script type="text/javascript">
        $(function() {
            $("#btnResetCustomHtmlArea").click(function() {
                $("#txtCustomHtmlArea").htmlarea("dispose");
                $("#txtCustomHtmlArea").htmlarea();
            });
        });
    </script>

	<br />
	<hr />
	<br />

	<script type="text/javascript">
       $.ui.dialog.defaults.bgiframe = true;
       $(function () {
           $("#dialog").dialog({
               width: 420, autoOpen: false,
               open: function (evt, ui) {
                   $("#dialogEditor").htmlarea();
               }
           });

           $("#dialogShowButton").click(function () {
               $('#dialog').dialog('open');

           });
       });
    </script>

	<div id="dialog" title="Basic dialog" style="display: none">
		Basic jHtmlArea within jQuery UI Dialog <br />
		<textarea id="dialogEditor" rows="10" style="width: 400px">Some <b>Basic</b> text.</textarea>
	</div>
</body>
</html>
