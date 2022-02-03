package uk.co.mettle.request.models;

import lombok.Builder;
import lombok.Data;
import uk.co.mettle.models.Currency;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Currencies {
    private LocalDateTime dateTime;
    private List<Currency> currencies;
}
