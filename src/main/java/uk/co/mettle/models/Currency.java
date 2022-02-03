package uk.co.mettle.models;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    private UUID id;
    private String name;
    private String code;
    private BigDecimal price;
    private BigInteger circulatingSupply;
    private BigDecimal marketCap;
    private BigDecimal percentageChange;

    public Currency(UUID id, String name, String code, BigDecimal price, BigInteger circulatingSupply, BigDecimal percentageChange) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.circulatingSupply = circulatingSupply;
        this.marketCap = new BigDecimal(circulatingSupply).multiply(price).setScale(2, RoundingMode.HALF_UP);
        this.percentageChange = percentageChange;
    }
}
