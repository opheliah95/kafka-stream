import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import static com.helper.github.opheliah95.MyConst.*;
import java.util.Properties;

public class SampleProducer {

    public SampleProducer() {

        // property field for producer
        Properties props = new Properties();
        props.put(SERVER, HOST);

        // serializer
        props.put("key.serializer",
                StringSerializer.class.getName());
        props.put("value.serializer",
                StringSerializer.class.getName());

        // get all write permission
        props.put("acks", "all");


        // create a new producer instance
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        KafkaProducer kafkaProducer = new KafkaProducer(props);

        // read some random values
        for (int i = 1; i <= 100; i++) {
            String key = Integer.toString(i); // generate key
            String val = "Message    : " + Integer.toString(i); // generate value
            ProducerRecord record = new ProducerRecord(TOPIC, key, val);
            producer.send(record);
        }

        kafkaProducer.close(); // close the producer


    }
}
