package uk.co.mettle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import uk.co.mettle.request.models.Currencies;
import uk.co.mettle.request.models.Currency;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

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
    public void getAllCurrencies() {
        Currencies currencies = given()
                .when().get("/currency/all")
                .then().statusCode(200)
                .extract().body().as(Currencies.class);

        assertThat(currencies.getCurrencies().get(0).getCode()).isEqualTo("BTC");
        assertThat(currencies.getCurrencies().get(0).getName()).isEqualTo("Bitcoin");
        assertThat(currencies.getCurrencies().get(1).getCode()).isEqualTo("ETH");
        assertThat(currencies.getCurrencies().get(1).getName()).isEqualTo("Ethereum");
    }

    @Test
    public void getACurrency() {
        Currency currency = given()
                .when().get("/currency/8123d9b9-b370-4b63-b2f9-81e38f02e01e")
                .then().statusCode(200).extract().body().as(Currency.class);
        assertThat(currency).isNotNull();
    }

    @Test
    public void addCurrency() {
        Currency currency = new Currency(UUID.randomUUID(), "Dogecoin", "DGE", new BigDecimal(0.1382), new BigInteger("132670764300"));
        given()
                .contentType(ContentType.JSON)
                .body(currency)
                .when().post("/currency")
                .then().statusCode(200);
    }
}
