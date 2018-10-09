package com.yushu.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
// 标记类和方法都可以
@Async
public class AsyncTask {
    public void test(){

    }
    public Future<String> testResult(){
        return new AsyncResult<String>("test");
    }
}
