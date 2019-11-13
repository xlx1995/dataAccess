package com.xlx.kafka.factory;

import com.xlx.commons.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author xlx
 * @descritption
 * @data 2019/10/25
 */
@Slf4j
public class KafkaProducerFactory {

    public Producer<String, String> getKafkaProducer() {
        Producer<String, String> producer = null;
        Properties props = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(Constants.KAFKA_PROPERTIES);
            if (inputStream != null) {
                props.load(inputStream);
                props.put(ProducerConfig.ACKS_CONFIG, "-1");
                props.put("retries", 3);
                props.put("batch.size", 323840);
                props.put("linger.ms", 10);
                props.put("buffer.memory", 33554432);
                props.put("max.block.ms", 3000);
                props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "lz4");
                props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 10485760);
                //k ,v 的序列化类
                props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                try {
                    producer = new KafkaProducer<String, String>(props);
                } catch (Throwable e) {
                    log.warn("fail to get kafkaProducer" + e);
                }
            } else {
                log.warn("fail to get inputstream");
                throw new Throwable("fail to get inputstream");
            }
        } catch (Throwable e) {
            log.warn("fail to get kafakConfig.properties --" + e);
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Throwable e) {
                log.warn("fail to close inputstream" + e);
            }
        }
        return producer;
    }

}
