package com.gal;

import com.gal.algo.Calc;
import com.gal.algo.MyCalc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class MyBeansConfig {

    @Bean(name = "beanStr")
    StringBuilder getStringBulder()
    {
        return new StringBuilder("bean from configration");
    }

    @Bean(name = "calcBean1")
    @Primary
    Calc getCalc()
    {
        return new MyCalc();
    }

    @Bean(name = "calcBean2")
    Calc getCalc2()
    {
        return new MyCalc();
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/taining");
        ds.setUsername("user");
        ds.setPassword("pass");
        return ds;
    }

//    scope
//    @Scope("singleton")
    //    @Scope("prototype") new object everytime bean aksed
    //    @Scope("request")
    //    @Scope("session")
    //    @Scope("application")

}
