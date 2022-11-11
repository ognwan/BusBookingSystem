/**
 * 
 */
package com.ognwan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ognwan.exceptions.NotFoundException;
import com.ognwan.model.Bus;
import com.ognwan.serviceImplementation.BusService;

import lombok.AllArgsConstructor;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/bus")
@AllArgsConstructor
public class BusController {
	@Autowired
	BusService busService;

	@PostMapping("/add-bus")
	public Bus add(@RequestBody Bus bus) {
		return busService.create(bus);
	}

	@PutMapping("/update-bus")
	public ResponseEntity<?> update(@RequestBody Bus bus, @RequestParam long busNum) {
		try {
			busService.updateBus(bus, busNum);
			return ResponseEntity.ok().build();
		} catch (NotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/get-bus/{busNum}")
	public ResponseEntity<String> getBus(@RequestParam long busNum) {
		try {
			busService.getById(busNum);
			return ResponseEntity.ok().build();
		} catch (NotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{busNum}")
	public ResponseEntity<?> delete(@PathVariable long busNum) {
		busService.delete(busNum);
		return ResponseEntity.ok().build();
	}
}
