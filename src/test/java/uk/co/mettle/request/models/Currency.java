package uk.co.mettle.request.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Data
@Builder
@JsonDeserialize(builder = Currency.CurrencyBuilder.class)
@AllArgsConstructor
public class Currency {
    private UUID id;
    private String name;
    private String code;
    private BigDecimal price;
    private BigInteger circulatingSupply;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrencyBuilder {
    }
}
