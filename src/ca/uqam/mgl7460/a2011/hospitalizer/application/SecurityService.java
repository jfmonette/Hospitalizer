package ca.uqam.mgl7460.a2011.hospitalizer.application;

import java.util.*;

import ca.uqam.mgl7460.a2011.hospitalizer.aspects.security.User;
import ca.uqam.mgl7460.a2011.hospitalizer.data.*;

public class SecurityService {
	public User authenticate(String userName, String password) {
		User authenticatedUser = null;
		PersistanceService persistance = new PersistanceService();
		Collection<Persistable> objects = persistance.getObjects(User.class);
		for (Persistable object : objects) {
			User user = (User) object;
			if (user.getUserName().equals(userName) && user.getPassword().equals(password))
				authenticatedUser = user;
		}
		return authenticatedUser;
	}

}
