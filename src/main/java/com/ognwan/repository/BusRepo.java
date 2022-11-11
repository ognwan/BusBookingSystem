/**
 * 
 */
package com.ognwan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ognwan.model.Bus;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Repository
public interface BusRepo extends JpaRepository<Bus, Long> {
	public Bus findBusByRoute(String route);
}
