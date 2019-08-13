package com.realpacific.springsparkcsvdemo.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realpacific.springsparkcsvdemo.entities.DataList;
import com.realpacific.springsparkcsvdemo.entities.Sales;
import lombok.val;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SparkStreamListener implements Runnable {

    private transient JavaStreamingContext jsc;

    @Autowired
    private transient JavaSparkContext javaSparkContext;

    @Override
    public void run() {
        jsc = new JavaStreamingContext(javaSparkContext, Durations.seconds(10));
        jsc.checkpoint("checkpoint");

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

            List<String> collect = rdd.collect();
            for (String c : collect) {
                ObjectMapper mapper = new ObjectMapper();
                DataList sales = mapper.readValue(c, DataList.class);
                System.out.println(sales + "!!!");
            }
        });

       /* JavaPairDStream<String, String> results = messages.mapToPair(record -> new Tuple2<>(record.key(), record.value()));

        JavaDStream<String> lines = results.map(Tuple2::_2);

        lines.foreachRDD(
                javaRdd -> {
                    List<String> collect = javaRdd.collect();
                    for (String c : collect) {
                        Gson gson = new Gson();
                        DataList sales = gson.fromJson(c, DataList.class);
                        System.out.println(sales + "!!!");
                    }
                }
        );*/
        jsc.start();
        try {
            jsc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
