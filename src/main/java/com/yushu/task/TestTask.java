package com.yushu.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.ni111shi.sh222azi;

@Component
public class TestTask {
    //@Scheduled(cron = "https://tool.lu/crontab")
    @Scheduled(fixedRate = 2000)
    public void test(){
        //System.out.println(new Date());
    }
	
}
