package com.credit.message;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class CreditMessageProducer {
	
    public void callCreditMessageProducer() throws ExecutionException, InterruptedException {
        System.out.println("CreditMessageProducer call keys...");
        final Logger logger = LoggerFactory.getLogger(CreditMessageProducer.class);
        //Creating properties
        String bootstrapServers="127.0.0.1:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //Creating Producer
        KafkaProducer<String, String> first_producer = new KafkaProducer<>(properties);

        String topic,value,key;
        topic="credit-message-new1";
         value="CM Axis Bank ";
         key="id_"+ 01;
        //ProducerRecord<String, String> record = new ProducerRecord<>("credit-message","CM Axis Bank");
        ProducerRecord<String, String> record = new ProducerRecord<>(topic,key,value);

        //Sending Data
        //first_producer.send(record);
        first_producer.send(record, (recordMetadata, e) -> {
            if (e== null) {
                logger.info("Successfully received the details as: \n" +
                        "Topic:" + recordMetadata.topic() + "\n" +
                        "Partition:" + recordMetadata.partition() + "\n" +
                        "Offset" + recordMetadata.offset() + "\n" +
                        "Timestamp" + recordMetadata.timestamp());
            }
            else {
                logger.error("Can't produce,getting error",e);
            }
        });

        first_producer.flush();
        first_producer.close();
    }
}