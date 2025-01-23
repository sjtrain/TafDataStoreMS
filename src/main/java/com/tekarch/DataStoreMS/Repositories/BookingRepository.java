package com.tekarch.DataStoreMS.Repositories;

import com.tekarch.DataStoreMS.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

