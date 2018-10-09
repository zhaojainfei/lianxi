package com.yushu.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCustomer {
    // 监听消息队列，有消息进来就消费
//    @JmsListener(destination = "test.queue")
//    public void receiveMsg(String msg){
//        System.out.println(msg);
//    }
//
//    @JmsListener(destination = "test.topic")
//    public void receiveTopicMsg(String msg){
//        System.out.println(msg);
//    }
//    @JmsListener(destination = "test.topic")
//    public void receiveTopicMsg1(String msg){
//        System.out.println(msg);
//    }
}
