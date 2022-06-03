package com.api.search;

import com.api.search.entity.Fare;
import com.api.search.entity.Flight;
import com.api.search.entity.Inventory;
import com.api.search.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SearchApiApplication implements CommandLineRunner {

	@Autowired
	private FlightRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SearchApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Flight> flights = new ArrayList<>();
		flights.add(new Flight("BF100", "SEA","SFO","22-JAN-18",new Inventory(100),new Fare("100", "USD")));
		flights.add(new Flight("BF101", "NYC","SFO","22-JAN-18",new Inventory(100),new Fare("101", "USD")));
		flights.add(new Flight("BF105", "NYC","SFO","22-JAN-18",new Inventory(100),new Fare("105", "USD")));
		flights.add(new Flight("BF106", "NYC","SFO","22-JAN-18",new Inventory(100),new Fare("106", "USD")));
		flights.add(new Flight("BF102", "CHI","SFO","22-JAN-18",new Inventory(100),new Fare("102", "USD")));
		flights.add(new Flight("BF103", "HOU","SFO","22-JAN-18",new Inventory(100),new Fare("103", "USD")));
		flights.add(new Flight("BF104", "LAX","SFO","22-JAN-18",new Inventory(100),new Fare("104", "USD")));

		repository.saveAll(flights);
	}
}
