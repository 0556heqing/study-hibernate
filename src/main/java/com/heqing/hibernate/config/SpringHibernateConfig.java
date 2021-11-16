package com.heqing.hibernate.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author heqing
 * @since 2021-07-21
 */
@Configuration
@ComponentScan("com.heqing.hibernate.*")
@EnableTransactionManagement
public class SpringHibernateConfig {

    /**
     * 配置数据源
     **/
    @Bean
    public DataSource dataSource(DBProperty dbProperty) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(dbProperty.getUser());
        dataSource.setPassword(dbProperty.getPassword());
        dataSource.setUrl(dbProperty.getUrl());
        dataSource.setDriverClassName(dbProperty.getDriverClass());
        dataSource.setInitialSize(dbProperty.getInitialSize());
        dataSource.setMinIdle(dbProperty.getMinIdle());
        dataSource.setMaxActive(dbProperty.getMaxActive());
        dataSource.setMaxWait(dbProperty.getMaxWait());
        dataSource.setValidationQuery(dbProperty.getValidationQuery());
        dataSource.setTestWhileIdle(dbProperty.getTestWhileIdle());
        dataSource.setTestOnBorrow(dbProperty.getTestOnBorrow());
        dataSource.setTestOnReturn(dbProperty.getTestOnReturn());
        dataSource.setTimeBetweenEvictionRunsMillis(dbProperty.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(dbProperty.getMinEvictableIdleTimeMillis());
        dataSource.setPoolPreparedStatements(dbProperty.getPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(dbProperty.getMaxPoolPreparedStatementPerConnectionSize());
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setPackagesToScan("com.heqing.hibernate.model");
        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory localSessionFactoryBean) {
        return new HibernateTransactionManager(localSessionFactoryBean);
    }

}
