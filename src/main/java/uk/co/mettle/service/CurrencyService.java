package uk.co.mettle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.mettle.exception.CurrencyNotFoundException;
import uk.co.mettle.models.Currencies;
import uk.co.mettle.models.Currency;
import uk.co.mettle.repository.CurrencyRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public Currencies getAllCurrencies() {
        List<Currency> currencies = currencyRepository.findAll();
        return new Currencies(currencies);
    }

    public void addCurrency(Currency currency) {
        currencyRepository.save(currency);
    }

    public Currency getCurrencyById(UUID id) {
        Currency currency = currencyRepository.findById(id).orElseThrow(() -> new CurrencyNotFoundException(id));
        try {
            int delay = 1000 + (int)(Math.random() * ((40000 - 1000) + 1));
            Thread.sleep(delay);
        } catch (InterruptedException exception) {

        }

        return currency;
    }

}
