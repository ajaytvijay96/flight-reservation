package com.ajay.flightreservation.services;

import com.ajay.flightreservation.dto.ReservationRequest;
import com.ajay.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
