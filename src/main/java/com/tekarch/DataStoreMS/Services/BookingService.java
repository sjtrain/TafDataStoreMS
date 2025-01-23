package com.tekarch.DataStoreMS.Services;
import com.tekarch.DataStoreMS.Models.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(Long bookingId);
    Booking updateBooking(Long bookingId,Booking updatedBookings);
    void deleteBooking(Long bookingId);
}