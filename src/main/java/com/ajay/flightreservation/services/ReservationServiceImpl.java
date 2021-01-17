package com.ajay.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.flightreservation.dto.ReservationRequest;
import com.ajay.flightreservation.entities.Flight;
import com.ajay.flightreservation.entities.Passenger;
import com.ajay.flightreservation.entities.Reservation;
import com.ajay.flightreservation.repos.FlightRepository;
import com.ajay.flightreservation.repos.PassengerRepository;
import com.ajay.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// make payment
		Long flightId = request.getFlightId();
		Optional<Flight> optflight = flightRepository.findById(flightId);
		Flight flight = optflight.get();
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		
		return savedReservation;
	}

}
