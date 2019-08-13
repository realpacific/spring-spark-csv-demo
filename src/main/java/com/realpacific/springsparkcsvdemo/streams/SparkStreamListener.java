package com.realpacific.springsparkcsvdemo.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realpacific.springsparkcsvdemo.entities.DataList;
import com.realpacific.springsparkcsvdemo.entities.Sales;
import com.realpacific.springsparkcsvdemo.respositories.SqlRepository;
import com.realpacific.springsparkcsvdemo.service.SqlService;
import lombok.val;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SparkStreamListener implements Runnable {

    private transient JavaStreamingContext jsc;

    @Autowired
    private transient JavaSparkContext javaSparkContext;

    @Autowired
    private SQLContext context;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @Override
    public void run() {
        Properties properties = new Properties();
        properties.put("user", username);
        properties.put("password", password);
        ObjectMapper mapper = new ObjectMapper();

        jsc = new JavaStreamingContext(javaSparkContext, Durations.seconds(2));
        // jsc.checkpoint("checkpoint");
        Map<String, Object> kafkaParams = new HashMap<>();
        kafkaParams.put("bootstrap.servers", "localhost:9092");
        kafkaParams.put("key.deserializer", StringDeserializer.class);
        kafkaParams.put("value.deserializer", StringDeserializer.class);
        kafkaParams.put("group.id", "group_id");
        kafkaParams.put("auto.offset.reset", "latest");
        kafkaParams.put("enable.auto.commit", true);

        Collection<String> topics = Arrays.asList("output");

        JavaInputDStream<ConsumerRecord<String, String>> messages = KafkaUtils.createDirectStream(jsc, LocationStrategies.PreferConsistent(),
                ConsumerStrategies.Subscribe(topics, kafkaParams));

        messages.map(ConsumerRecord::value).foreachRDD(rdd -> {

            if (rdd.count() > 0) {
                JavaRDD<DataList> map = rdd.map(status -> {
                    DataList event = mapper.readValue(status, DataList.class);
                    System.out.println(event + "!!!");
                    return event;
                });

                context.createDataFrame(map, DataList.class).write().mode(SaveMode.Append).
                        jdbc(url, "tbl", properties);
            }
        });
        jsc.start();
        try {
            jsc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
