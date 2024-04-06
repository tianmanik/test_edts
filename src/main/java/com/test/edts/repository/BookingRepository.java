package com.test.edts.repository;

import com.test.edts.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;


public interface BookingRepository extends JpaRepository<Booking,Long> {

	long countByBookingTimeBetween (Timestamp start, Timestamp end);
}
