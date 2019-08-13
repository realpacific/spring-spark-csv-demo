package com.realpacific.springsparkcsvdemo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * DataList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-12T15:16:14.802+05:45[Asia/Kathmandu]")

@Entity
@Data
@Table(name = "tbl")
@AllArgsConstructor
@NoArgsConstructor
public class DataList implements Serializable {
    @JsonProperty("reference")
    @Id
    private Integer reference;

    @JsonProperty("amount")
    @Column(name = "amount")
    private Integer amount;

    @JsonProperty("applicant")
    @Column(name = "applicant")
    private String applicant;

    @JsonProperty("beneficiary")
    @Column(name = "beneficiary")
    private String beneficiary;

    @JsonProperty("serviceType")
    @Column(name = "serviceType")
    private String serviceType;

    @JsonProperty("dueDate")
    @Column(name = "dueDate")
    private String dueDate;

    @JsonProperty("paidDate")
    @Column(name = "paidDate")
    private String paidDate;

    @JsonProperty("currency")
    @Column(name = "currency")
    private String currency;

    @JsonProperty("country")
    @Column(name = "country")
    private String country;

}

