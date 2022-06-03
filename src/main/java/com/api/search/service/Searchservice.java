package com.api.search.service;

import com.api.search.entity.Flight;
import com.api.search.entity.Inventory;
import com.api.search.entity.SearchQuery;
import com.api.search.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Searchservice {

    private FlightRepository flightRepository;

    private static final Logger logger = LoggerFactory.getLogger(Searchservice.class);


    @Autowired
    public Searchservice(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> search(SearchQuery query) {
        List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightDate(query.getOrigin(),
                query.getDestination(),
                query.getFlightDate());


        List<Flight> searchResult = new ArrayList<Flight>();
        searchResult.addAll(flights);
        flights.forEach(flight -> {
            flight.getFare();
            int inv = flight.getInventory().getCount();
            if (inv < 0) {
                searchResult.remove(flight);
            }
        });
        return searchResult;
    }

    public void updateInventory(String flightNumber, String flightDate, int inventory) {
        logger.info("Updating inventory for flight " + flightNumber + " innventory " + inventory);
        Flight flight = flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
        Inventory inv = flight.getInventory();
        inv.setCount(inventory);
        flightRepository.save(flight);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }


}
