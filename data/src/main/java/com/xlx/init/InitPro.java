package com.xlx.init;

import com.xlx.kafka.SendCallback;
import com.xlx.kafka.factory.KafkaProducerFactory;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;

/**
 * @author xlx
 */
@Component
@PropertySource(value = "classpath:application.yml")
public class InitPro {

    private Executor taskExecutor;

    @Value("${xlx.url}")
    private String url;

//    @Autowired
//    private KafkaProducerFactory kafkaProducerFactory;

    @Autowired
    public void setTaskExecutor(Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @PostConstruct
    public void init() {
        System.out.println("url:----" + url);
//        Runnable runnable = () -> {
//            Producer<String, String> kafkaProducer = kafkaProducerFactory.getKafkaProducer();
//            kafkaProducer.send(new ProducerRecord<>("user", "aaaa","aaaa"), (SendCallback) (metadata, exception) -> {
//                if(exception == null){
//                    System.out.println("发送成功");
//                }else{
//                    kafkaProducer.close();
//                }
//            });
//            kafkaProducer.close();
//        };
//        taskExecutor.execute(runnable);
    }

}
