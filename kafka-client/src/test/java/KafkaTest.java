import com.xlx.kafka.SendCallback;
import com.xlx.kafka.factory.KafkaProducerFactory;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

/**
 * @author xlx
 * @descritption
 * @data 2019/10/25
 */
public class KafkaTest {

    @Test
    public void t1(){
        KafkaProducerFactory kafkaProducerFactory = new KafkaProducerFactory();
        Producer<String, String> kafkaProducer = kafkaProducerFactory.getKafkaProducer();
        kafkaProducer.send(new ProducerRecord<>("user", "aaaa","aaaa"), (SendCallback) (metadata, exception) -> {
            if(exception == null){
                System.out.println("发送成功");
            }else{
                kafkaProducer.close();
            }
        });
        kafkaProducer.close();
    }

}
