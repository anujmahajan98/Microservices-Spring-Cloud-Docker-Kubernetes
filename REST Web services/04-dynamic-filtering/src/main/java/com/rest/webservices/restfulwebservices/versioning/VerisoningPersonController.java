package com.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerisoningPersonController {

    //Versioning using URL
    @GetMapping("/v1/person")
    public Person1 getFirstVersionOfPerson(){
        return new Person1("Anuj Mahajan");
    }

    @GetMapping("/v2/person")
    public Person2 getSecondVersionOfPerson(){
        return new Person2(new Name("Anuj", "Mahajan"));
    }

    //Versioning using Request Parameters
    @GetMapping(value = "/person", params = "version=1")
    public Person1 getFirstVersionOfPersonRequestParams(){
        return new Person1("Anuj Mahajan");
    }

    @GetMapping(value = "/person", params = "version=2")
    public Person2 getSecondVersionOfPersonRequestParams(){
        return new Person2(new Name("Anuj", "Mahajan"));
    }

    //Versioning using header
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public Person1 getFirstVersionOfPersonRequestHeader(){
        return new Person1("Anuj Mahajan");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public Person2 getSecondVersionOfPersonRequestHeader(){
        return new Person2(new Name("Anuj", "Mahajan"));
    }

    //Versioning using Accept Headers
    @GetMapping(value = "/person/accept", produces = "application/microservice.app-v1+json")
    public Person1 getFirstVersionOfPersonAcceptHeader(){
        return new Person1("Anuj Mahajan");
    }

    @GetMapping(value = "/person/accept", produces = "application/microservice.app-v2+json")
    public Person2 getSecondVersionOfPersonAcceptHeader(){
        return new Person2(new Name("Anuj", "Mahajan"));
    }
}
