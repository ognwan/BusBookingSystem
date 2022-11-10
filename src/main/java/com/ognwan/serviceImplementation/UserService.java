/**
 * 
 */
package com.ognwan.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ognwan.exceptions.UserAlreadyExistsException;
import com.ognwan.exceptions.UserNotFoundException;
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
	public User create(User user) throws UserAlreadyExistsException {
		if (userRepo.findUserByEmail(user.getEmail()) != null
				|| userRepo.findUserByPhoneNumber(user.getPhoneNumber()) != null) {
			throw new UserAlreadyExistsException("User already exists");
		}
		return userRepo.save(user);
	}

	@Override
	public User update(User user, long userId) throws UserNotFoundException {
		User foundUser = userRepo.findById(userId).get();
		if (foundUser == null) {
			throw new UserNotFoundException("No user with ID " + userId);
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
	public User getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
