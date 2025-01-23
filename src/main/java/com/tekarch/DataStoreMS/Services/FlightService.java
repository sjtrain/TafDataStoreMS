package com.tekarch.DataStoreMS.Services;

import com.tekarch.DataStoreMS.Models.Flight;

import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);
    List<Flight> getAllFlights();
    Flight getFlightById(Long flightId);
    Flight updateFlight(Flight flight);
    void deleteFlight(Long flightId);

}