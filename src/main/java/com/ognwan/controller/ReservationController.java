/**
 * 
 */
package com.ognwan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ognwan.exceptions.NotFoundException;
import com.ognwan.model.Reservation;
import com.ognwan.model.User;
import com.ognwan.serviceImplementation.ReservationService;
import com.ognwan.serviceImplementation.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	UserService userService;

	@PostMapping("/new-booking")
	public ResponseEntity<?> createReservation(@RequestBody Reservation reservation, @RequestParam long userId,
			String departure, String arrival) {
		try {
			User user = userService.getById(userId);
			reservationService.create(user, departure, arrival);
			return ResponseEntity.ok().build();
		} catch (NotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
