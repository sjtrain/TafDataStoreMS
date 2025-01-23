package com.tekarch.DataStoreMS.Services.Impl;

import com.tekarch.DataStoreMS.Models.Flight;

import com.tekarch.DataStoreMS.Models.User;
import com.tekarch.DataStoreMS.Repositories.FlightRepository;
import com.tekarch.DataStoreMS.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(Long flightId) {
        return flightRepository.findById(flightId).orElse(null);
    }


    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);  // Save the updated flight object
    }




    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
