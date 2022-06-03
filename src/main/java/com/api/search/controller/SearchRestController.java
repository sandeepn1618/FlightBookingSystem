package com.api.search.controller;

import com.api.search.repository.FlightRepository;
import com.api.search.service.Searchservice;
import com.api.search.entity.Flight;
import com.api.search.entity.SearchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchRestController {

    @Autowired
    private Searchservice searchservice;

    @Autowired
    private FlightRepository repository;

   // @Value("${originairports.shutdown}")
    private String originAirportShutdownList;

    @PostMapping("/get")
    public List<Flight> searchFlight(@RequestBody SearchQuery query){
        System.out.println("Input : "+ query);
        if (Arrays.asList(originAirportShutdownList.split(","))
                .contains(query.getOrigin())) {
            System.out.println("The origin airport is in shutdown state.");
            return new ArrayList<Flight>();
        }
        return searchservice.search(query);
    }

    @PostMapping("/saveFlight")
    public Flight saveFlight(@RequestBody Flight flight){
        return searchservice.saveFlight(flight);
    }

   @GetMapping("/getFlight")
    public List<Flight> getFlight(){
        return  repository.findAll();
   }
}
