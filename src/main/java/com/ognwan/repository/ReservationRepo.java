/**
 * 
 */
package com.ognwan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ognwan.model.Reservation;

/**
 * @author gerry
 * @version 1.0
 * 
 */
public interface ReservationRepo extends JpaRepository<Reservation, Long> {

}
