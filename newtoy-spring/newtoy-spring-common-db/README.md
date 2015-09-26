Spring-common-db

This module contains common dependencies for db like :

    * newtoy-spring-common
    * spring-jdbc
    * spring-tx
    
It contains for db connection pools :
 
    * tomcat-jdbc
    * HikariCP
    * commons-dbcp
    
You can choose one db connection pool from the list above in the ${newToy.externalConfHome}/dbConf.properties file.

newToy.externalConfHome variable can be fixed in the src/main/resources/properties/newToyConf.properties file.