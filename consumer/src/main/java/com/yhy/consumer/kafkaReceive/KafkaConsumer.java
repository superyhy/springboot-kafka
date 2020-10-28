package com.yhy.consumer.kafkaReceive;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"testTopic1"})
    public void topic1Consumer(ConsumerRecord<String, String> record) {
        log.info("收到消息：" + record.value());
    }

    /**
     * 监听testTopic1的0号和1号分区，1号分区的offset初始值为8
     *
     * @param record
     */
    @KafkaListener(topicPartitions = {
            @TopicPartition(topic = "testTopic1", partitions = "0", partitionOffsets
                    = @PartitionOffset(partition = "1", initialOffset = "8"))
    })
    public void topicConsumer2(ConsumerRecord<String, String> record) {
        log.info("收到消息：" + record.value());
    }

    @KafkaListener(topics = {"testTopic2"})
    public void topicConsumer3(List<ConsumerRecord<String, String>> records) {
        log.info("开始一次批量消费,size=" + records.size());
        for (ConsumerRecord<String, String> record : records) {
            System.out.println(record.value());
        }
    }
}