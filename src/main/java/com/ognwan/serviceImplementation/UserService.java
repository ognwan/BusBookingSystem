/**
 * 
 */
package com.ognwan.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ognwan.exceptions.AlreadyExistsException;
import com.ognwan.exceptions.NotFoundException;
import com.ognwan.model.Reservation;
import com.ognwan.model.User;
import com.ognwan.repository.UserRepo;
import com.ognwan.service.ServiceInterface;

import lombok.AllArgsConstructor;

/**
 * @author gerry
 * @version 1.0
 * 
 */
@Service
@AllArgsConstructor
public class UserService implements ServiceInterface<User, Reservation> {
	@Autowired
	UserRepo userRepo;

	@Override
	public User create(User user) throws AlreadyExistsException {
		if (userRepo.findUserByEmail(user.getEmail()) != null
				|| userRepo.findUserByPhoneNumber(user.getPhoneNumber()) != null) {
			throw new AlreadyExistsException("User already exists");
		}
		return userRepo.save(user);
	}

	@Override
	public User update(User user, long userId) throws NotFoundException {
		User foundUser = userRepo.findById(userId).get();
		if (foundUser == null) {
			throw new NotFoundException("No user with ID " + userId);
		}
		if (user.getEmail() != null) {
			foundUser.setEmail(user.getEmail());
		}
		if (user.getName() != null) {
			foundUser.setName(user.getName());
		}
		if (user.getPhoneNumber() != null) {
			foundUser.setPhoneNumber(user.getPhoneNumber());
		}
		if (user.getCreditCardBalance() != 0) {
			foundUser.setCreditCardBalance(user.getCreditCardBalance());
		}
		User updatedUser = userRepo.save(foundUser);
		return updatedUser;
	}

	@Override
	public User getById(long id) throws NotFoundException {
		return userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public void delete(long userId) {
		userRepo.deleteById(userId);
	}
}
