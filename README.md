# Parsing CSV file using Apache Spark with Spring Boot

Reads test.csv file located on /resources and retrieves useful information from it.

## Endpoints

|  Endpoints | Description  |
|---|---|
|  [localhost:8080/per-day](http://localhost:8080/per-day) |  Sum of amounts grouped by day  |
|  [localhost:8080/total](http://localhost:8080/total) |  Total amount involved in the csv  |


## Expected topic message @ topic "order"
```json
{ 
   "Transaction_date":"1/2/09 6:17",
   "Product":"Product1",
   "Price":1200,
   "Payment_Type":"Mastercard",
   "Name":"carolina",
   "City":"Basildon",
   "State":"England",
   "Country":"United Kingdom",
   "Account_Created":"1/2/09 6:00",
   "Last_Login":"1/2/09 6:08",
   "Latitude":51.5,
   "Longitude":-1.1166667
}

```

## Initialization
* `docker-compose up`
* `Conduktor` to publish message to topic

## References
* https://www.conduktor.io/
* https://www.baeldung.com/kafka-spark-data-pipeline
* https://spark.apache.org/docs/latest/streaming-kafka-0-10-integration.html