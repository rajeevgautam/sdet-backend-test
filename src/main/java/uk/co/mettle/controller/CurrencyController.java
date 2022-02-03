package uk.co.mettle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.mettle.entity.CurrencyEntity;
import uk.co.mettle.models.Currencies;
import uk.co.mettle.models.Currency;
import uk.co.mettle.service.CurrencyService;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/currency/all")
    public ResponseEntity<Currencies> findAll() {
        return ok(currencyService.getAllCurrencies());
    }

    @GetMapping( "/currency/{id}")
    public ResponseEntity<Currency> findById(@PathVariable UUID id) {
        return ok(currencyService.getCurrencyById(id));
    }

    @PostMapping( "/currency")
    public CurrencyEntity addCurrency(@RequestBody CurrencyEntity currency) {
        currencyService.addCurrency(currency);
        return currency;
    }

}
