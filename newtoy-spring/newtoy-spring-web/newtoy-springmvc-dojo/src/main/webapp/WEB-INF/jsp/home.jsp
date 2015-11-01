<!DOCTYPE html>
<%@include file="taglibs.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Tutorial: Hello Dojo!</title>

    <script>
    /**
     * By default DOJO look for all module as sibling of dojo lib,
     * In our case it is ""${baseURL}/resources/lib/dojo".
     * To modify this default behavior, we override default location by providing dojoConfig.
     */
     var dojoConfig = {
     async: true,
     packages: [{
     name: "app",
     location: "${baseURL}/resources/app"
     }]
     };
     </script>
</head>
<body>
    <div id="greeting">Hello</div>
    <div id="test"></div>
 <button id="testBttn">Say Hello</button>
 
    
    <!-- load Dojo -->
    <script src="${baseURL}/resources/lib/dojo/dojo.js" data-dojo-config="async: true"></script>

    <script type="text/javascript">
	 /**
	 * require() is a foundational AMD API.
	 * Fetch the module on run time and only after it is done with loading of one or list of module,
	 * it call the callback function, which go as second argument.
	 */
	 require(["app/simple/myModule", "app/simple/Modules"
	 ],
	 function(MyModule, Modules) {
	
		 MyModule.setText('greeting', 'Hello Dojo!');
         setTimeout(function () {
        	 MyModule.restoreText('greeting');
         }, 3000);
         
		  var widget = new Modules();
	
	 });
	 </script>
</body>
</html>
