Parent spring module.

This module contains the spring common dependencies for the child modules :

    * spring-common :  contains common utilities like PropertyLoader, ResourceLoader, Exceptions...
    * spring-common-db : contains common dependencies for db. This module references spring-common module. 
    * spring-jdbc : This module references spring-common-db module.
    * spring-mybatis : This module references spring-common-db module.
    * spring-mvc : This module references spring-mybatis module.