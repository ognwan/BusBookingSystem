/**
 * 
 */
package com.ognwan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@Column(nullable = false, updatable = false)
	@JsonProperty(access = Access.READ_ONLY)
	private long id;
	@NotBlank(message = "name cannot be blank")
	private String name;
	private String phoneNumber;
	private String email;
	private double creditCardBalance;
	@OneToMany
	private List<Reservation> reservations;
}
