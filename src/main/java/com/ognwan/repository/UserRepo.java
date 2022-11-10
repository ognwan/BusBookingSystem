/**
 * 
 */
package com.ognwan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ognwan.model.User;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findUserByEmail(String email);

	User findUserByPhoneNumber(String phoneNumber);

}
