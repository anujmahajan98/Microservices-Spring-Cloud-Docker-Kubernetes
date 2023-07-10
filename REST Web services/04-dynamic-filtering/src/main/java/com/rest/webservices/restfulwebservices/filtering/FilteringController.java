package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filteringDemo")
    public MappingJacksonValue filtering(){
        DemoBean demoBean = new DemoBean("val1", "val2", "val3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(demoBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DemoBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filteringDemo-list")
    public MappingJacksonValue filteringList(){
        List<DemoBean> demoBeanList = Arrays.asList(new DemoBean("val11", "val12", "val13"),
                new DemoBean("val21", "val22", "val23"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(demoBeanList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DemoBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;

    }
}
