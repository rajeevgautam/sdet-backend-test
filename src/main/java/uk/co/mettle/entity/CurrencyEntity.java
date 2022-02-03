package uk.co.mettle.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Data
@Table(name = "currency")
@Entity()
public class CurrencyEntity {
    @Id
    @Type(type="uuid-char")
    private UUID id;
    @Column
    private String name;
    @Column
    private String code;
    @Column
    protected BigDecimal price;
    @Column(name="circulating_supply")
    protected BigInteger circulatingSupply;

}
