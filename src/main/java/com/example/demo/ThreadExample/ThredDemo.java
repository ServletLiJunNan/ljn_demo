package com.example.demo.ThreadExample;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 线程的一个例子 主讲future
 * Created by za-lijunnan on 2018/8/20.
 */
public class ThredDemo {
    @Autowired
    private ExecutorService executorService;
    public void runs(){
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
    }
}
