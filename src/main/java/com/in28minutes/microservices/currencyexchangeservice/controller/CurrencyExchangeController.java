package com.in28minutes.microservices.currencyexchangeservice.controller;

import com.in28minutes.microservices.currencyexchangeservice.entity.CurrencyValue;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CurrencyExchangeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment environment;

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyValue getCurrencyValue(@PathVariable String from, @PathVariable String to){
        logger.info("Inside Currency exchange service");
        Optional<CurrencyValue> currencyValueOp = currencyRepository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
        CurrencyValue currencyValue = currencyValueOp.get();
        currencyValue.setPort(Integer.parseInt(environment.getProperty("server.port")));
        logger.info("Returning response from exchange service --> {}", currencyValue);
        return currencyValue;
    }
}
