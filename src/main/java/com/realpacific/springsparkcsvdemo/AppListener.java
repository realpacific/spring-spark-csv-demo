package com.realpacific.springsparkcsvdemo;

import com.realpacific.springsparkcsvdemo.streams.SparkStreamListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class AppListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ac = event.getApplicationContext();
        SparkStreamListener runnable = ac.getBean(SparkStreamListener.class);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
