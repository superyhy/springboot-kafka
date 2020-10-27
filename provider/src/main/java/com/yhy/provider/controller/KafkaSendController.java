package com.yhy.provider.controller;

import com.yhy.provider.kafkasender.SendTopic1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaSendController {
    @Autowired
    SendTopic1 sendTopic1;

    @GetMapping("/sendMessage")
    public void sendToTopic1(String message){
        sendTopic1.sendToTopic1(message);
    }



}
