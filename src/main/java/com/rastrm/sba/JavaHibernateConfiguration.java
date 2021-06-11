package com.rastrm.sba;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;


@Configuration
public class JavaHibernateConfiguration {
    @Bean
    public EntityManager entityManager(SessionFactory sessionFactory) {
        return sessionFactory.createEntityManager();
    }

    @Bean
    public DataSource dataSource()  {
        MysqlDataSource dataSource = new MysqlDataSource();
        try {
            dataSource.setServerTimezone("UTC");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        dataSource.setUser("user");
        dataSource.setPassword("user");
        dataSource.setURL("jdbc:mysql://localhost:3306/store");

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.rastrm.sba.entity");
        sessionFactoryBean.setHibernateProperties(properties());

        return sessionFactoryBean;
    }

    private Properties properties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        return hibernateProperties;
    }
}
