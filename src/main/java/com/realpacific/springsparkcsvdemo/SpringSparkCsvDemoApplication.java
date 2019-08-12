package com.realpacific.springsparkcsvdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSparkCsvDemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringSparkCsvDemoApplication.class);
        app.addListeners(new AppListener());
        app.run(args);
    }

}
