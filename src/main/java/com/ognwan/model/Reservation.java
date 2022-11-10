/**
 * 
 */
package com.ognwan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	@Id
	@Column(nullable = false, updatable = false)
	private long ticketId;
	private int busNumber = (int) Math.random() * 4;
	private String from;
	private String to;
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

}
