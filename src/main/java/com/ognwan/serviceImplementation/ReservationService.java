/**
 * 
 */
package com.ognwan.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ognwan.exceptions.NotFoundException;
import com.ognwan.model.Reservation;
import com.ognwan.model.User;
import com.ognwan.repository.BusRepo;
import com.ognwan.repository.ReservationRepo;

import lombok.AllArgsConstructor;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Service
@AllArgsConstructor
public class ReservationService {
	@Autowired
	private ReservationRepo reservationRepo;
	@Autowired
	private BusRepo busRepo;

	public Reservation create(User user, String from, String to) {
		Reservation newReservation = new Reservation();
		newReservation.setFrom(from);
		newReservation.setTo(to);
		newReservation.setUser(user);
		newReservation.setBusNumber(busRepo.findBusByRoute(from + "-" + to).getBusNumber());
		return reservationRepo.save(newReservation);
	}

	public Reservation update(Reservation reservation, long id) throws NotFoundException {
		Reservation foundReservation = reservationRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Reservation not found"));
		if (reservation.getFrom() != null) {
			foundReservation.setFrom(reservation.getFrom());
		}
		if (reservation.getTo() != null) {
			foundReservation.setTo(reservation.getTo());
		}

		return reservationRepo.save(foundReservation);
	}

	public Reservation getById(long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
