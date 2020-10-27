package com.yhy.consumer.kafkaReceive;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"testTopic1"})
    public void topic1Consumer(ConsumerRecord<String, String> record){
        log.info("收到消息："+record.value());
    }
}