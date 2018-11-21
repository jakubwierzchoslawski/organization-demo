package jw.workshop.spring.organizationservice.infrastructure.spring;

import javax.sql.DataSource;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public  class CloudFoundryDatabaseConfig {

    @Bean
    public Cloud cloud() {
        return new CloudFactory().getCloud();
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = cloud().getServiceConnector("postgres-external", DataSource.class, null);
        return dataSource;
    }
    
    
/*    @Value("${vcap.services.postgres.credentials.jdbc_uri}")
    private String postgresUrl;

    @Value("${vcap.services.postgres.credentials.username}")
    private String postgresUsername;

    @Value("${vcap.services.postgres.credentials.password}")
    private String postgresPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriverClassName;

    @Primary
    @Bean
    public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName(dataSourceDriverClassName);
        dataSource.setUrl(postgresUrl);
        dataSource.setUsername(postgresUsername);
        dataSource.setPassword(postgresPassword);
        dataSource.setInitialSize(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(25);
        return dataSource;
    }
*/
}