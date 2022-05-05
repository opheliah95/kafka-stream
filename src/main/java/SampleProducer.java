import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SampleProducer {
    public SampleProducer(){
        // property field for producer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");

        // serializer
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");


        // create a new producer instance
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        ProducerRecord record = new ProducerRecord("hello-kafka","author","steve jobs");
        KafkaProducer kafkaProducer = new KafkaProducer(props);

        kafkaProducer.send(record);
        kafkaProducer.close(); // close the producer






    }
}
