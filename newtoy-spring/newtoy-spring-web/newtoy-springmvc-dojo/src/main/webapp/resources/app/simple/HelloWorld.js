/**
 * define() is a foundational AMD API.
 * It allows us to define a module and its dependencies.
 * Once dojo/query and dojo/on are loaded (which doesn't happen until their dependencies are loaded, and so on),
 * the callback function is called and module instance passed to it.
 */

define([
    "dojo/_base/declare",
    "dojo/query",
    "dojo/on"
], function(declare, query, on) {

    /**
     * dojo/_base/declare is not port of foundational AMD API.
     * It is provided by DOJO to simulate class-based inheritance by encapsulating JavaScript prototype-based inheritance.
     */
    return declare(null, {

        helloText: "Hello...thanks for pressing button!",

        init: function() {
            var button = query("#testBttn")[0],
                target = query("#test")[0];

            on(button, "click", function() {
                console.log("Button pressed");
                target.innerHTML = this.helloText;
            }.bind(this))
        }
    });
});