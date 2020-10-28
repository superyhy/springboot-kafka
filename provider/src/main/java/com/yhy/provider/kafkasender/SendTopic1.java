package com.yhy.provider.kafkasender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class SendTopic1 {

    @Autowired
    KafkaTemplate kafkaTemplate;

    /**
     * 方法回调
     *
     * @param message
     */
    public void sendToTopic1(String message) {
        kafkaTemplate.send("testTopic1", message).addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                //消息发送失败的补偿机制
                System.out.println("发送消息失败：" + throwable.getMessage());
            }

            @Override
            public void onSuccess(Object o) {
                System.out.println("消息发送成功");
            }
        });
    }

    /**
     * 声明事务，后面报错消息不回发出去
     *
     * @param message
     */
    public void sendInTransaction(String message){
        //如果后面出现错误，这条消息不回发出去
        kafkaTemplate.executeInTransaction(kafkaOperations -> {
            return kafkaOperations.send("testTopic1","发送事务测试消息到topic1");
        });

    }
}

