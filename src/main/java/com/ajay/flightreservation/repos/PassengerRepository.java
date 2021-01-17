package com.ajay.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
