/**
 * define() is a foundational AMD API.
 * It allows us to define a module and its dependencies.
 */

define([
    "dojo/_base/declare"
], function(declare) {

    var A = declare(null, {

        constructor: function() {

            console.log("In constructor A");
        }
    });

    var B = declare(null, {

        constructor: function() {

            console.log("In constructor B");
        }

    });

    var C = declare(null, {

        constructor: function() {

            console.log("In constructor C");
        }

    });

    return declare([A, B, C], {

        constructor: function() {
            console.log("Check who am i!!")
            console.log("Type A: ", this instanceof A); //true
            console.log("Type B: ", this instanceof B); //false
            console.log("Type C: ", this instanceof C); //false

        }
    });
});