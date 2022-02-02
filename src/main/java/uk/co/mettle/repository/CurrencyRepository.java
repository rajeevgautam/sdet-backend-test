package uk.co.mettle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.mettle.models.Currency;

import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
}
