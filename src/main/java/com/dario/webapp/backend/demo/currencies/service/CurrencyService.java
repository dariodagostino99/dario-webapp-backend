package com.dario.webapp.backend.demo.currencies.service;

import com.dario.webapp.backend.demo.authorization.model.NomicsCurrency;
import com.dario.webapp.backend.demo.currencies.model.Currency;
import com.dario.webapp.backend.demo.currencies.model.HistoricCurrencyDTO;
import com.dario.webapp.backend.demo.currencies.repository.CurrencyRepository;
import com.dario.webapp.backend.demo.currencies.type.CurrencyType;
import liquibase.repackaged.org.apache.commons.lang3.Validate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Transactional(readOnly = true)
    public HistoricCurrencyDTO getCurrencyHistoricValues(String currencyName) {
        Validate.notNull(currencyName);
        //
        CurrencyType currencyType = CurrencyType.valueOf(currencyName.toUpperCase());
        List<Currency> currencies = currencyRepository.findTop2ByCurrencyTypeOrderByIdDesc(currencyType);
        HistoricCurrencyDTO historicCurrency = null;
        try {
            historicCurrency = HistoricCurrencyDTO.builder()
                    .currencyType(currencyType)
                    .actualValue(currencies.get(0).getValue())
                    .previousValue(currencies.get(1).getValue())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicCurrency;
    }

    @Transactional
    public void updateCurrencyValue(List<NomicsCurrency> nomicsCurrency) {
        Validate.notNull(nomicsCurrency);
        //
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
        List<Currency> currencies = nomicsCurrency.stream()
                .map(n -> Currency.builder()
                        .currencyType(CurrencyType.valueOf(n.getId()))
                        .value(Double.valueOf(n.getPrice()))
                        .date(ZonedDateTime.parse(n.getPriceDate()))
                        .build())
                .collect(Collectors.toList());
        currencyRepository.saveAll(currencies);
        log.info("[CURRENCY-JOB] - Job finished successfully at: {}", LocalDateTime.now());
    }
}
