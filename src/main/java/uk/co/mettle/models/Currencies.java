package uk.co.mettle.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Currencies {
    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();
    private List<Currency> currencies;
}
