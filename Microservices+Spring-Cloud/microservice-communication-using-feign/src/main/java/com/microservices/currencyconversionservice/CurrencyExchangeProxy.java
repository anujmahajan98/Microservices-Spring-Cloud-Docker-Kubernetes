package com.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name = "currency-exchange", url = "localhost:8000")
// This one is when we don't have Eureka naming server.
// In that case we have to provide hardcoded URL as well to tell form where to pick this currency-exchange
// Now as we have naming server and currency-exchange is registered with it, and also our this microservice has eureka dependency
// We can simply use @FeignClient without URL like below
@FeignClient(name = "currency-exchange") //With Eureka Naming server
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
