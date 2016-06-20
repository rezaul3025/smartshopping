package org.smart.shoping.persistence.services;

import org.smart.shoping.core.domain.User;

public interface UserService {
	User getUserByEmail(String username);
}
