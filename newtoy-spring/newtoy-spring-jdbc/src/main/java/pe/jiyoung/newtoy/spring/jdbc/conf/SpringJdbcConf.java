package pe.jiyoung.newtoy.spring.jdbc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pe.jiyoung.newtoy.spring.common.db.conf.BaseDatabaseConfig;

@Configuration
@EnableTransactionManagement
public class SpringJdbcConf extends BaseDatabaseConfig{

    @Bean
    public DataSourceTransactionManager  transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }
}
