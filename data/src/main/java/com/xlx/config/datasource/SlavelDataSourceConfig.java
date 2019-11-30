package com.xlx.config.datasource;

import com.xlx.util.DataSourceUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/13
 */
@Configuration
@MapperScan(basePackages = "com.xlx.mapper.slavel", sqlSessionTemplateRef = "slavelSqlSessionTemplate")
public class SlavelDataSourceConfig {

    @Autowired
    private SlavelConfig slavelConfig;

    @Bean(name = "slavelDataSource")
    public DataSource setDataSource() throws SQLException {
        DataSourceConfig dataSourceConfig = new DataSourceConfig(slavelConfig.getUrl(),slavelConfig.getUsername(),slavelConfig.getPassword(),slavelConfig.getPlatform(),slavelConfig.getMinIdle(),slavelConfig.getMaxActive(),slavelConfig.getValidationQuery());
        return DataSourceUtil.createDataSource(dataSourceConfig,"slavelDataSource");
    }

//    @Bean(name = "slavelTransactionManager")
//    public DataSourceTransactionManager setTransactionManager(@Qualifier("slavelDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name = "slavelSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("slavelDataSource") DataSource dataSource) throws Exception {
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
