package com.realpacific.springsparkcsvdemo.controller;

import com.realpacific.springsparkcsvdemo.service.CsvProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class AppController {

    private final CsvProcessorService service;

    @GetMapping("/per-day")
    public Map<String, Integer> getTotalAmountInOneDay() {
        return service.calculateTotalAmountInOneDay();
    }


    @GetMapping("/total")
    public Integer getTotalAmountInvolved() {
        return service.calculateSumOfAllAmounts();
    }

}
