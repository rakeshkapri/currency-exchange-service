package com.in28minutes.microservices.currencyexchangeservice.repository;

import com.in28minutes.microservices.currencyexchangeservice.entity.CurrencyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<CurrencyValue, Integer> {
    Optional<CurrencyValue> findByFromAndTo(String from, String to);
}
