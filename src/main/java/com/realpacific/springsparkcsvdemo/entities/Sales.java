package com.realpacific.springsparkcsvdemo.entities;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  Sales  implements Serializable {

    @SerializedName("Price")
    private String price;

    @SerializedName("Last_Login")
    private String lastLogin;

    @SerializedName("State")
    private String state;

    @SerializedName("Product")
    private String product;

    @SerializedName("Country")
    private String country;

    @SerializedName("Latitude")
    private String latitude;

    @SerializedName("Transaction_date")
    private String transactionDate;

    @SerializedName("City")
    private String city;

    @SerializedName("Account_Created")
    private String accountCreated;

    @SerializedName("Payment_Type")
    private String paymentType;
    @SerializedName("Longitude")
    private String longitude;

    @SerializedName("Name")
    private String name;
}


