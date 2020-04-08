package com.pg.bbs.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
@MapperScan("com.pg.bbs.dao")
public class DataSourceConfig {
    @Value("${jdbc.username}")
    private String jdbcUser;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${jdbc.driver}")
    private String jdbcDriverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(jdbcUser);
        comboPooledDataSource.setPassword(jdbcPassword);
        comboPooledDataSource.setDriverClass(jdbcDriverClass);
        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        comboPooledDataSource.setAutoCommitOnClose(false);
        comboPooledDataSource.setTestConnectionOnCheckin(false);
        comboPooledDataSource.setTestConnectionOnCheckout(true);
        return comboPooledDataSource;
    }
}
