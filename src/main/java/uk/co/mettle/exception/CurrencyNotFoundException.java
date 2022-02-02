package uk.co.mettle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static java.lang.String.format;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Currency Not Found")
public class CurrencyNotFoundException extends RuntimeException {

    public CurrencyNotFoundException(UUID id) {
        super(format("Could not find the Currency with id: %s", id));
    }

}
