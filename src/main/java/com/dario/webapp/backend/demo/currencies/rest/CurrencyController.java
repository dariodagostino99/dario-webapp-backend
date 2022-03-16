package com.dario.webapp.backend.demo.currencies.rest;

import com.dario.webapp.backend.demo.currencies.model.HistoricCurrencyDTO;
import com.dario.webapp.backend.demo.currencies.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/{currency}")
    public HistoricCurrencyDTO getCurrencyHistoricValues(@PathVariable("currency") String currencyName){
        return currencyService.getCurrencyHistoricValues(currencyName);
    }
}
