package com.ajay.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.flightreservation.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
