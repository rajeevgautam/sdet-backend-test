package uk.co.mettle.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uk.co.mettle.exception.CurrencyNotFoundException;
import uk.co.mettle.models.Currencies;
import uk.co.mettle.models.Currency;
import uk.co.mettle.service.CurrencyService;

import java.util.List;
import java.util.Optional;
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
    public Currency addCurrency(@RequestBody Currency currency) {
        currencyService.addCurrency(currency);
        return currency;
    }

}
