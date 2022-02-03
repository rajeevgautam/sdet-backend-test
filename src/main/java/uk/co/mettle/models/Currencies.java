package uk.co.mettle.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Currencies {
    private List<Currency> currencies;
    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();
}
