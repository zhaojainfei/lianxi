package com.yushu.controller;

import com.yushu.service.ProductorService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;


@Controller
public class TestMQController {
    @Autowired
    ProductorService productorService;

    @RequestMapping(value = "/sendMsg",method = RequestMethod.GET)
    @ResponseBody
    public Object sendMsg(String message){
        Destination destination = new ActiveMQQueue("test.queue");
        productorService.sendMessage(destination,message);
        return null;
    }

    @RequestMapping(value = "/publishMsg",method = RequestMethod.GET)
    @ResponseBody
    public Object publishMsg(String message){
        Destination destination = new ActiveMQTopic("test.topic");
        productorService.sendMessage(destination,message);
        return null;
    }
}
