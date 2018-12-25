package com.in28minutes.microservices.currencyexchangeservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CURRENCY_VALUE")
public class CurrencyValue {
    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "CONVERSION_MULTIPLE")
    private BigDecimal conversionMultiple;
    @Transient
    private int port;

    public CurrencyValue(Long id, String from, String to, BigDecimal conversionMultiple){
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
