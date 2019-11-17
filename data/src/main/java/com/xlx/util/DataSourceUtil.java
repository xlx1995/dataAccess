package com.xlx.util;

import com.mysql.cj.jdbc.MysqlXADataSource;
import com.xlx.config.datasource.DataSourceConfig;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/17
 */
public class DataSourceUtil {

    public static DataSource createDataSource(DataSourceConfig dataSourceConfig,String dataSourceName) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dataSourceConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dataSourceConfig.getPassword());
        mysqlXaDataSource.setUser(dataSourceConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        // 将本地事务注册到创 Atomikos全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(dataSourceName);
        xaDataSource.setMinPoolSize(dataSourceConfig.getMinIdle());
        xaDataSource.setMaxPoolSize(dataSourceConfig.getMaxActive());
        xaDataSource.setMaxLifetime(dataSourceConfig.getMaxActive());
        xaDataSource.setBorrowConnectionTimeout(30);
        xaDataSource.setLoginTimeout(30);
        xaDataSource.setMaintenanceInterval(60);
        xaDataSource.setMaxIdleTime(60);
        xaDataSource.setTestQuery(dataSourceConfig.getValidationQuery());
        return xaDataSource;
    }

}
