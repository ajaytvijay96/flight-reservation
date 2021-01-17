package com.ajay.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.flightreservation.dto.ReservationUpdateRequest;
import com.ajay.flightreservation.entities.Reservation;
import com.ajay.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRESTController {
 
	@Autowired
	ReservationRepository reservationRepository;
	
	@GetMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		System.out.println("inside reservations");
		Optional<Reservation> findById = reservationRepository.findById(id);
		if(findById.isPresent()) {
			System.out.println(findById.get());
			return findById.get();
		}
			return null;
	}
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> findById = reservationRepository.findById(request.getId());
		Reservation reservation;
		if(findById.isPresent()) {
		reservation=findById.get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		Reservation updatedReservation = reservationRepository.save(reservation);
		return updatedReservation;
		}
	   
	   return null;
	}
	
}
