package com.venuebooking.venue_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.venuebooking.venue_booking_system.model.Booking;

@Repository
public interface BookingRepository  extends CrudRepository<Booking, Integer>{
	@Query("FROM Booking WHERE venueid=:venueid")
	List<Booking> findByVenueId(@Param("venueid") Integer venueid);
	@Query("FROM Booking WHERE owneremail=:owneremail")
	List<Booking> findByowneremail(@Param("owneremail") String owneremail);
}
