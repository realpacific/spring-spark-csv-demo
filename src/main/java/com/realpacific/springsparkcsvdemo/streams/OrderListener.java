package com.realpacific.springsparkcsvdemo.streams;

import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    //@KafkaListener(topics = "order", groupId = "group_id")
    public void consume(String message) {
        logger.info(String.format("$$ -> Consumed Message -> %s", message));
    }
}