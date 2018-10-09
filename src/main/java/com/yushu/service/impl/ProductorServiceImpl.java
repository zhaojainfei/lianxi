package com.yushu.service.impl;

import com.yushu.service.ProductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import javax.jms.Queue;
import javax.jms.Destination;

@Service
public class ProductorServiceImpl implements ProductorService {
    @Autowired
    // 发送消息到Broker的模板
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Override
    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    @Override
    public void sendMessage(String message) {
        jmsMessagingTemplate.convertAndSend(message);
    }

    @Override
    public void publishMsg(String message){
        jmsMessagingTemplate.convertAndSend(message);
    }
}
