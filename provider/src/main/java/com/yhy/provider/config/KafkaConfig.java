package com.yhy.provider.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * kafka配置类
 *
 * @author yuhanyi
 * @date 2020/20/27
 */
@Configuration
public class KafkaConfig {

    //创建一个名为testTopic1的topic并设置分区数为8，分区副本数为2
    @Bean
    public NewTopic testTopic1() {
        return new NewTopic("testTopic1",8, (short) 2);
    }

    //如果要修改分区数，只需修改配置值重启项目即可
    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
    @Bean
    public NewTopic testTopic2(){
        return new NewTopic("testTopic2",10, (short) 2);
    }


}
