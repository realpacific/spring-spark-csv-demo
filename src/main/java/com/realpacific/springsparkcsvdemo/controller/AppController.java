package com.realpacific.springsparkcsvdemo.controller;

import com.realpacific.springsparkcsvdemo.entities.DataList;
import com.realpacific.springsparkcsvdemo.service.CsvProcessorService;
import com.realpacific.springsparkcsvdemo.service.SqlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class AppController {

    private final CsvProcessorService csvService;
    private final SqlService sqlService;

    @GetMapping("/per-day")
    public Map<String, Integer> getTotalAmountInOneDay() {
        return csvService.calculateTotalAmountInOneDay();
    }


    @GetMapping("/total")
    public Integer getTotalAmountInvolved() {
        return csvService.calculateSumOfAllAmounts();
    }


    @GetMapping("/sql")
    public List<DataList> queryDataList() {
        return sqlService.retrieveAllEvents();
    }

}
