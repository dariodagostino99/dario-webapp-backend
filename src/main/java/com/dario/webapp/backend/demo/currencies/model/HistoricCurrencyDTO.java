package com.dario.webapp.backend.demo.currencies.model;


import com.dario.webapp.backend.demo.currencies.type.CurrencyType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoricCurrencyDTO {

    private CurrencyType currencyType;

    private Double actualValue;

    private Double previousValue;

}
