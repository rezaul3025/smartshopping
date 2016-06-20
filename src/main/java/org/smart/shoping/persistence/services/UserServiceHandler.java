package org.smart.shoping.persistence.services;

import org.smart.shoping.core.domain.User;
import org.smart.shoping.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceHandler implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User getUserByEmail(String username) {
		return userRepo.findByEmail(username);
	}

}
