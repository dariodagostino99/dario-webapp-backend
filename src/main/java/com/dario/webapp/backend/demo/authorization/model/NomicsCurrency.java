package com.dario.webapp.backend.demo.authorization.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NomicsCurrency {

    @JsonAlias("id")
    private String id;

    @JsonAlias("price_date")
    private String priceDate;

    @JsonAlias("price")
    private String price;

}
