# sdet-backend-test
A technical test for sdet candidates. The test contains a springboot service with RestAssured & Junit5 tests. The objective is to fix and flakey tests, improve the quality of code and fix any bugs.

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
```
 

