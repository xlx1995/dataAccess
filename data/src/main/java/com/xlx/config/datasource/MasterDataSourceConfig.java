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
@MapperScan(basePackages = "com.xlx.mapper.miaosha", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDataSourceConfig {

    @Autowired
    private MasterConfig masterConfig;

    @Bean(name = "masterDataSource")
    public DataSource setDataSource() throws SQLException {
        DataSourceConfig dataSourceConfig = new DataSourceConfig(masterConfig.getUrl(),masterConfig.getUsername(),masterConfig.getPassword(),masterConfig.getPlatform(),masterConfig.getMinIdle(),masterConfig.getMaxActive(),masterConfig.getValidationQuery());
        return DataSourceUtil.createDataSource(dataSourceConfig,"masterDataSource");

    }

//    @Bean(name = "masterTransactionManager")
//    public DataSourceTransactionManager setTransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name = "masterSqlSessionFactory")

    public SqlSessionFactory setSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(setDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/xlx/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "masterSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
