import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;
import java.util.Arrays;
import static com.helper.github.opheliah95.MyConst.*;

public class SampleConsumer {

    public static void main(String[] args){
        Properties prop = new Properties();
        prop.put(SERVER, HOST);
        prop.put("group.id", GROUP_ID);
        prop.put("enable.auto.commit", AUTO_COMMIT);
        prop.put("auto.commit.interval.as", COMMIT_INTERVAL);
        prop.put("key.deserializer", StringDeserializer.class.getName());
        prop.put("value.deserializer", StringDeserializer.class.getName());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(prop);
        consumer.subscribe(Arrays.asList(TOPIC_LIST));
        // consumer record
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record: records){
                System.out.printf("offset=%d, key=%s, value=%s\n", record.offset(), record.key(), record.value());
            }

        }

    }


}
