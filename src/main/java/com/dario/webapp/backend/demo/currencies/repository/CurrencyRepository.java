package com.dario.webapp.backend.demo.currencies.repository;

import com.dario.webapp.backend.demo.currencies.model.Currency;
import com.dario.webapp.backend.demo.currencies.type.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Query
    List<Currency> findTop2ByCurrencyTypeOrderByIdDesc(CurrencyType currencyType);
}
