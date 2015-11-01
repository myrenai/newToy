<!DOCTYPE html>
<%@include file="taglibs.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Tutorial: Hello Dojo!</title>

    <%@include file="dojoConfig.jsp"%>
</head>
<body>
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
	 require([
	 "app/simple/HelloWorld"
	 ],
	 function(HelloWorld) {
	
	 var helloWorld = new HelloWorld();
	 helloWorld.init();
	
	 });
	 </script>
</body>
</html>
