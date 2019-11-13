package com.xlx.kafka.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

/**
 * @Auther: 徐林啸
 * @Date: 2019/7/17 21:30
 * @Description:
 */
@Slf4j
@PropertySource(value = "classpath:kafkaConfig.properties")
public class AdminClientFacotry {

    @Value("${bootstrap.servers}")
    private static String address;

    public AdminClient getAdminClient(){
        AdminClient client = null;
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, address);
        try{
            client = AdminClient.create(properties);
        }catch (Throwable e){
            log.error("fail to create AdminClient ---" , e);
        }
        return client;
    }




}
