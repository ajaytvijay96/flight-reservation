package com.ajay.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajay.flightreservation.entities.Flight;
import com.ajay.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
    @Autowired
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	@Autowired
	FlightRepository flightRepository;
	
	
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
			ModelMap modelMap) {
		LOGGER.info("Inside findFlights()"+from +" to "+to+"departureDate "+departureDate);
		List<Flight> flights = flightRepository.findFlights(from,to,departureDate);
		modelMap.addAttribute("flights",flights);
		return "displayFlights";
	}
	
}
