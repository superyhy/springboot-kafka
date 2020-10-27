package com.yhy.provider.kafkasender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class SendTopic1 {

    @Autowired
    KafkaTemplate kafkaTemplate;


    public void sendToTopic1(String message){
        kafkaTemplate.send("testTopic1",message).addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                //消息发送失败的补偿机制
                System.out.println("发送消息失败："+throwable.getMessage());
            }

            @Override
            public void onSuccess(Object o) {
                 System.out.println("消息发送成功");
            }
        });
    }
}

