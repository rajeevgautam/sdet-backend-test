# sdet-backend-test
A technical test for SDET candidates. The test contains a springboot service with RestAssured & Junit5 tests. The objective is to improve the quality of code and fix the flaky tests.

## **Currency service**

#### **Run the Application**
```
mvn spring-boot:run
```

#### **Run the Tests**
```
mvn test
```
---
#### **API doc**

_GET_ - Retrieve all currencies
```
/currency/all
```

_GET_ - Retrieve a currency
```
/currency/{id}
```
_POST_ - Add a currency
```
/currency

{
    "id": "07015c51-9182-4217-824e-9f3611d04f2c",
    "name": "Dogecoin",
    "code": "DGE",
    "price": 0.1382,
    "circulatingSupply": 132670764300
}
```
 

