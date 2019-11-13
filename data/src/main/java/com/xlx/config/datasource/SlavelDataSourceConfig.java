package com.xlx.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/13
 */
@Configuration
@MapperScan(basePackages = "com.xlx.mapper.slavel", sqlSessionTemplateRef = "slavelSqlSessionTemplate")
public class SlavelDataSourceConfig {

    @Bean(name = "slavelDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave1")
    public DruidDataSource setDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "slavelTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("slavelDataSource") DruidDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slavelSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("slavelDataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(setDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/blog/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "slavelSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("slavelSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }




}
