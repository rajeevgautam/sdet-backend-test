package uk.co.mettle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import uk.co.mettle.request.models.Currencies;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CurrencyTest {

    @LocalServerPort
    int port;

    @BeforeAll
    public void beforeAll() {
        RestAssured.port = port;
    }

    @Test
    public void successfullyRetrieveCurrenciesInRankingOrder() {
        Currencies currencies = given()
                .when().get("/currency/all")
                .then().statusCode(200)
                .extract().body().as(Currencies.class);

        assertThat(currencies.getCurrencies().get(0).getName()).isEqualTo("Bitcoin");
        assertThat(currencies.getCurrencies().get(1).getName()).isEqualTo("Ethereum");
        assertThat(currencies.getCurrencies().get(2).getName()).isEqualTo("BNB");
        assertThat(currencies.getCurrencies().get(3).getName()).isEqualTo("Cardano");
        assertThat(currencies.getCurrencies().get(4).getName()).isEqualTo("Solana");
        assertThat(currencies.getCurrencies().get(5).getName()).isEqualTo("Ripple");
    }


    @Test
    public void successfullyAddCurrency() {
        Map<String, Object> currencyToAdd = new HashMap();
        currencyToAdd.put("id", "07015c51-9182-4217-824e-9f3611d04f2c");
        currencyToAdd.put("name", "Dogecoin");
        currencyToAdd.put("code", "DGE");
        currencyToAdd.put("price", 123.12);
        given()
                .contentType(ContentType.JSON)
                .body(currencyToAdd)
                .when().post("/currency")
                .then().statusCode(200);
    }

    @Test
    public void successfullyRetrieveCurrency() {
        given().when().get("/currency/07015c51-9182-4217-824e-9f3611d04f2c");
    }

}
