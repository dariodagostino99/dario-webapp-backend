package com.dario.webapp.backend.demo.currencies.feign;

import com.dario.webapp.backend.demo.authorization.model.NomicsCurrency;
import com.dario.webapp.backend.demo.currencies.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class NomicCurrencyFetcherJob {

    @Autowired
    private NomicsFeignClient nomicsFeignClient;
    @Autowired
    private CurrencyService currencyService;

    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime(){
        log.info("[CURRENCY-JOB] - Task started at: {}", LocalDateTime.now());
        //
        try{
            List<NomicsCurrency> nomicsCurrencyList = nomicsFeignClient.getNomicsCurrency();
            nomicsCurrencyList.forEach(n -> log.info("[CURRENCY-JOB] - Currency: {} - Value: {} - Timestamp: {}", n.getId(), n.getPrice(), n.getPriceDate()));
            currencyService.updateCurrencyValue(nomicsCurrencyList);
        } catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }
}
