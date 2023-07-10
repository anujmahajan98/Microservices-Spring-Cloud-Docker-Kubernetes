package com.microservices.currencyexchangeservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
    @RateLimiter(name = "default")
    public String sampleApi(){
        //For Retry and CircuitBreaker use the below dummy API call, as we want to fail the call
//        logger.info("Sample API call received !!! ");
//        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);
//        return responseEntity.getBody();

        //For RateLimiter return a valid response because we don't want to fail the api call
        return "Sample API";
    }

    public String hardCodedResponse(Exception ex){
        return "We are down currently, please revisit after some time";
    }
}
