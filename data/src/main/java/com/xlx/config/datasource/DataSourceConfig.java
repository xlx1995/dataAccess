package com.xlx.config.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceConfig{

    private String url;
    private String username;
    private String password;
    private String platform;
    private int minIdle;
    private int maxActive;
    private String validationQuery;

}
