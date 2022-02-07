package uk.co.mettle.request.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@JsonDeserialize(builder = Currency.CurrencyBuilder.class)
@AllArgsConstructor
public class Currency {
    private UUID id;
    private String name;
    private String code;
    private Double price;
    private Double circulatingSupply;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrencyBuilder {
    }
}
