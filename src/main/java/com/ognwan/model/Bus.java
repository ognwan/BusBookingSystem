/**
 * 
 */
package com.ognwan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Entity
@AllArgsConstructor
@Data
public class Bus {
	@Id
	@Column(nullable = false)
	private long busNumber;
	private String route;
}
