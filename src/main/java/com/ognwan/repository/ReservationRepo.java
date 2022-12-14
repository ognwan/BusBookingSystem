/**
 * 
 */
package com.ognwan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ognwan.model.Reservation;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {

}
