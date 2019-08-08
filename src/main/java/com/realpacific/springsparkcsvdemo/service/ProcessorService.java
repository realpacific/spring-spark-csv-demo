package com.realpacific.springsparkcsvdemo.service;

import com.realpacific.springsparkcsvdemo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProcessorService {

    private final JavaSparkContext sc;
    private final ResourceLoader resourceLoader;

    public Map<String, Integer> getTotalAmountInOneDay() {
        JavaRDD<String> input = inputFromFile();

        return input
                .flatMap(in -> Arrays.asList(in.split("\n")).iterator())
                .mapToPair(line -> {
                    String[] words = line.split(",");
                    String date = words[0].split(" ")[0];
                    Integer amount = Integer.valueOf(words[2]);
                    return new Tuple2<>(date, amount);
                })
                .reduceByKey(Integer::sum)
                .collectAsMap();
    }


    public Integer getSumOfAllAmounts() {
        JavaRDD<String> input = inputFromFile();
        return input
                .flatMap(in -> Arrays.asList(in.split("\n")).iterator())
                .map(line -> {
                    String amountStr = line.split(",")[2];
                    Integer amount = Integer.valueOf(amountStr);
                    return amount;
                })
                .reduce(Integer::sum);
    }

    private JavaRDD<String> inputFromFile() {
        Resource resource = this.resourceLoader.getResource("classpath:test.csv");
        JavaRDD<String> input;
        try {
            input = sc.textFile(resource.getFile().getPath());
        } catch (IOException e) {
            throw new ResourceNotFoundException(e);
        }
        return input;
    }
}