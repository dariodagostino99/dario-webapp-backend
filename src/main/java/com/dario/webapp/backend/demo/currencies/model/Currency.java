package com.dario.webapp.backend.demo.currencies.model;


import com.dario.webapp.backend.demo.currencies.type.CurrencyType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "currencies")
@Entity
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency_name")
    @Enumerated(value = EnumType.STRING)
    private CurrencyType currencyType;

    @Column
    private Double value;

    @Column(name = "time_stamp")
    private ZonedDateTime date;
}
