package com.venuebooking.venue_booking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venuebooking.venue_booking_system.model.Booking;
import com.venuebooking.venue_booking_system.model.VenueAmenities;
import com.venuebooking.venue_booking_system.repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Authorization")
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	@GetMapping("/getbookings")
	public List<Booking> getBookings(){
		return (List<Booking>) bookingRepository.findAll();
	}
	@PostMapping("/addbookings")
	public String addBooking(@RequestBody Booking booking) {
		bookingRepository.save(booking);
		return "success";
	}
	@PostMapping("/updatebookings")
	public String updateBooking(@RequestBody Booking booking) {
		bookingRepository.save(booking);
		return "sucess";
	}
	@GetMapping("/getbookings/{id}")
	public List<String> getBooking(@PathVariable int  id) {
		List<Booking> bookings=bookingRepository.findByVenueId(id);
		List<String> approved=new ArrayList<String>();
		for(Booking booking:bookings) {
			if(booking.getStatus().equals("APPROVED")) {
				approved.add(booking.getBookedDate());
			}
		}
		return  approved;
	}

	@GetMapping("/getbookingsowner/{owneremail}")
	public List<Booking> getBookingByowner(@PathVariable String  owneremail) {
		return  bookingRepository.findByowneremail(owneremail);
	}

}
