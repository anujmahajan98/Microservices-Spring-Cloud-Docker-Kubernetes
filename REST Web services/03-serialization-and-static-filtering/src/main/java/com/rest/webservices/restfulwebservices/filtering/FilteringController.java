package com.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filteringDemo")
    public DemoBean filtering(){
        return new DemoBean("val1", "val2", "val3");
    }

    @GetMapping("/filteringDemo-list")
    public List<DemoBean> filteringList(){
        return Arrays.asList(new DemoBean("val11", "val12", "val13"),
                new DemoBean("val21", "val22", "val23"));
    }
}
