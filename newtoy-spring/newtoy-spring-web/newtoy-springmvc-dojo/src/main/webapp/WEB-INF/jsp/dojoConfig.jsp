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