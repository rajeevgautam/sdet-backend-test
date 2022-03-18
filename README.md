# sdet-backend-test
A technical test for SDET candidates. The test contains a springboot service with RestAssured & Junit5 tests. The objective is to improve the quality of code and fix the flaky tests.
#### **Acceptance Criteria**
Given a currency is an available currency\
When a user retrieves the currency by id\
Then the user receives the currency's information (id, name, code, price, circulating supply, market cap and percentage change)\
**Note: The market cap is calculated by (price x circulating supply). The percentage change is a change on the price and will be updated on each refresh**

Given a currency is not an available currency\
When a user creates the currency with the information (id, name, code, price, circulating supply)\
Then the currency is added\
And the user can retrieve the currency's information that was just added

Given multiple currencies are available\
When a user retrieves all the currencies\
Then the user receives the currency's information (id, name, code, price, circulating supply, market cap and percentage change)


---
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
 

