package com.realpacific.springsparkcsvdemo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProcessorServiceTest {

    @Autowired
    ProcessorService service;

    @Test
    void totalAmountInADayShouldBeEqualToSumOfIndividualTransactionAmountOnThatDay() {
        Map<String, Integer> totalAmountInOneDay = service.getTotalAmountInOneDay();
        Assertions.assertThat(totalAmountInOneDay.get("1/2/09")).isEqualTo(1200 * 40);
    }

    @Test
    void totalAmountShouldBeEqualToSumOfAllAmountInTransaction() {
         Integer totalAmount = service.getSumOfAllAmounts();
        Assertions.assertThat(totalAmount).isEqualTo(1341200);
    }
}