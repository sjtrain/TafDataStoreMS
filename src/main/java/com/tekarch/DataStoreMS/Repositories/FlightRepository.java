package com.tekarch.DataStoreMS.Repositories;
import com.tekarch.DataStoreMS.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}

