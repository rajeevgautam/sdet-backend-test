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
                .map(currencyEntity -> createCurrency(currencyEntity))
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

        try {
            int delay = 3 + (int) (Math.random() * ((6 - 3) + 1));
            Thread.sleep(delay * 1000);
        } catch (InterruptedException exception) {

        }

        return createCurrency(currencyEntity);
    }

    private Currency createCurrency(CurrencyEntity currencyEntity) {
        BigDecimal percentageChange = getRandomPercentage();
        BigDecimal multiplyPercentage = percentageChange.movePointLeft(2).add(BigDecimal.ONE);
        return new Currency(currencyEntity.getId(),
                currencyEntity.getName(),
                currencyEntity.getCode(),
                currencyEntity.getPrice().multiply(multiplyPercentage).setScale(2, RoundingMode.HALF_UP),
                currencyEntity.getCirculatingSupply(),
                percentageChange);
    }

    private BigDecimal getRandomPercentage() {
        BigDecimal min = BigDecimal.valueOf(6.9);
        BigDecimal max = BigDecimal.valueOf(59.9);
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

}
