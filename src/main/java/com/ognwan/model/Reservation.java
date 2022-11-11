/**
 * 
 */
package com.ognwan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String from;
	private String to;
	private long busNumber;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;

}
