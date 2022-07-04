package uk.co.mettle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.mettle.entity.CurrencyEntity;
import uk.co.mettle.exception.CurrencyNotFoundException;
import uk.co.mettle.models.Currencies;
import uk.co.mettle.models.Currency;
import uk.co.mettle.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public Currencies getAllCurrencies() {
        List<CurrencyEntity> allCurrencies = currencyRepository.findAll();
        List<Currency> currencies = allCurrencies.stream()
                .map(currencyEntity -> toCurrency(currencyEntity))
                .sorted((e1, e2) -> e2.getMarketCap().compareTo(e1.getMarketCap()))
                .collect(Collectors.toList());
        return Currencies.builder()
                .currencies(currencies)
                .build();
    }

    public void addCurrency(CurrencyEntity currency) {
        currencyRepository.save(currency);
    }

    public Currency getCurrencyById(UUID id) {
        CurrencyEntity currencyEntity = currencyRepository.findById(id).orElseThrow(() -> new CurrencyNotFoundException(id));
        return toCurrency(currencyEntity);
    }

    private Currency toCurrency(CurrencyEntity currencyEntity) {
        BigDecimal percentageChange = getPercentageFluctuation();
        BigDecimal multiplyPercentage = percentageChange.movePointLeft(2).add(BigDecimal.ONE);
        return new Currency(currencyEntity.getId(),
                currencyEntity.getName(),
                currencyEntity.getCode(),
                currencyEntity.getPrice().multiply(multiplyPercentage).setScale(2, RoundingMode.HALF_UP),
                currencyEntity.getCirculatingSupply(),
                percentageChange);
    }

    private BigDecimal getPercentageFluctuation() {
        BigDecimal min = BigDecimal.valueOf(6.9);
        BigDecimal max = BigDecimal.valueOf(59.9);
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

}
