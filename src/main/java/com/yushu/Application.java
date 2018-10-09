package com.yushu;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.jms.Queue;

@SpringBootApplication

// 使用servlet3.0的注解进行配置，扫描filter
//@ServletComponentScan

@MapperScan(basePackages = "com.yushu.mapper")
// 开启定时任务
//@EnableScheduling
// 开启异步任务
//@EnableAsync
// 开启消息队列
//@EnableJms
public class Application{

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
//		return applicationBuilder.sources(Application.class);
//	}

	@Bean(name = "queue")
	public Queue getQueue(){
		return new ActiveMQQueue("test.queue");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
