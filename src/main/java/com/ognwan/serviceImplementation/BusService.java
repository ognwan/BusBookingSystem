
package com.ognwan.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ognwan.exceptions.NotFoundException;
import com.ognwan.model.Bus;
import com.ognwan.repository.BusRepo;

import lombok.AllArgsConstructor;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Service
@AllArgsConstructor
public class BusService {
	@Autowired
	BusRepo busRepo;

	public Bus create(Bus bus) {
		return busRepo.save(bus);
	}

	public Bus getById(long busNum) throws NotFoundException {
		return busRepo.findById(busNum).orElseThrow(() -> new NotFoundException("Bus not found"));
	}

	public Bus updateBus(Bus bus, long busNum) throws NotFoundException {
		Bus foundBus = busRepo.findById(busNum).orElseThrow(() -> new NotFoundException("bus " + busNum + "not found"));
		foundBus.setRoute(bus.getRoute());
		return foundBus;
	}

	public void delete(long busNum) {
		busRepo.deleteById(busNum);
	}
}
