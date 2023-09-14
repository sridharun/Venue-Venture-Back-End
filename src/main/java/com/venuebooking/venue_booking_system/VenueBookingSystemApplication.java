package com.venuebooking.venue_booking_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.venuebooking.venue_booking_system.domain.User;
import com.venuebooking.venue_booking_system.fileupload.FileStorageProperties;
import com.venuebooking.venue_booking_system.repository.ConstantUtils;
import com.venuebooking.venue_booking_system.repository.UserServiceImpl;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class VenueBookingSystemApplication  implements CommandLineRunner{
	
	@Autowired
	private UserServiceImpl userService;

	
	public static void main(String[] args) {
		
		SpringApplication.run(VenueBookingSystemApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		if (userService.findAll().isEmpty()) {
			User user1 = new User();
			user1.setEmail("testuser@gmail.com");
			user1.setName("Test User");
			user1.setMobile("9787456545");
			user1.setPassword(new BCryptPasswordEncoder().encode("12345"));
			userService.saveOrUpdate(user1);

			User user2 = new User();
			user2.setEmail("sridharun.p93@gmail.com");
			user2.setName("Test Admin");
			user2.setMobile("9787456545");
			user2.setPassword(new BCryptPasswordEncoder().encode("12345"));
			userService.saveOrUpdate(user2);
		}
	}

}
