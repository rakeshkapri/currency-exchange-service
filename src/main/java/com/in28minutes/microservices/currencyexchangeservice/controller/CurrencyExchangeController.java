package com.in28minutes.microservices.currencyexchangeservice.controller;

import com.in28minutes.microservices.currencyexchangeservice.entity.CurrencyValue;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CurrencyExchangeController {
    @Autowired
    Environment environment;

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyValue getCurrencyValue(@PathVariable String from, @PathVariable String to){
        Optional<CurrencyValue> currencyValueOp = currencyRepository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
        CurrencyValue currencyValue = currencyValueOp.get();
        currencyValue.setPort(Integer.parseInt(environment.getProperty("server.port")));
        return currencyValue;
    }
}
