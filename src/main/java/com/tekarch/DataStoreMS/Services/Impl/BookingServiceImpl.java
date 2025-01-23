package com.tekarch.DataStoreMS.Services.Impl;


import com.tekarch.DataStoreMS.Models.Booking;
import com.tekarch.DataStoreMS.Models.Flight;
import com.tekarch.DataStoreMS.Models.User;
import com.tekarch.DataStoreMS.Repositories.BookingRepository;
import com.tekarch.DataStoreMS.Repositories.FlightRepository;
import com.tekarch.DataStoreMS.Repositories.UserRepository;
import com.tekarch.DataStoreMS.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Booking createBooking(Booking booking) {
        // Validate user
        User user = userRepository.findById(booking.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + booking.getUserId()));

        // Validate flight and check seat availability
        Flight flight = flightRepository.findById(booking.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + booking.getFlightId()));

        if (flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("Flight is fully booked. No seats available.");
        }

        // Reduce available seats
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);

        // Save booking
        booking.setStatus("Booked");
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

        // Update booking details (except ID and createdAt fields)
        existingBooking.setFlightId(updatedBooking.getFlightId());
        existingBooking.setUserId(updatedBooking.getUserId());
        existingBooking.setStatus(updatedBooking.getStatus());
        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long bookingId) {
        // Mark the booking as cancelled
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

        booking.setStatus("Cancelled");
        bookingRepository.save(booking);
    }
}
