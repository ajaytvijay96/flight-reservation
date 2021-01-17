package com.ajay.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajay.flightreservation.dto.ReservationRequest;
import com.ajay.flightreservation.entities.Flight;
import com.ajay.flightreservation.entities.Reservation;
import com.ajay.flightreservation.repos.FlightRepository;
import com.ajay.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
    @RequestMapping(value = "/showCompleteReservation",method = RequestMethod.GET)
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
    	Optional<Flight> flight = flightRepository.findById(flightId);
    	if(flight.isPresent())
    	{
    	modelMap.addAttribute("flight", flight.get());
    	}
    	return "completeReservation";
    }
	
    @RequestMapping(value = "/completeReservation",method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request,ModelMap modelMap) {
    	Reservation reservation = reservationService.bookFlight(request);
    	modelMap.addAttribute("msg","Reservation created successfully and the id is "+ reservation.getId());
    	return "reservationConfirmation";
    }
}
