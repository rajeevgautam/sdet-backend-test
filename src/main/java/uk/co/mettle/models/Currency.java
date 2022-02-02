package uk.co.mettle.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currency")
@Entity()
public class Currency {
    @Id
    @Type(type="uuid-char")
    private UUID id;
    private String name;
    private String code;

}
