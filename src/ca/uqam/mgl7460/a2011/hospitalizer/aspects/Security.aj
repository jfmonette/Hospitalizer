package ca.uqam.mgl7460.a2011.hospitalizer.aspects;

import java.util.Collection;
import ca.uqam.mgl7460.a2011.hospitalizer.application.*;
import ca.uqam.mgl7460.a2011.hospitalizer.data.*;
import ca.uqam.mgl7460.a2011.hospitalizer.security.*;
import ca.uqam.mgl7460.a2011.hospitalizer.security.roles.*;
import ca.uqam.mgl7460.a2011.hospitalizer.domain.*;

public aspect Security {
	private User user = new User();
	
	pointcut authenticate() : call(User SecurityService.authenticate(..));
	after() returning(User user) : authenticate() {
		this.user = user;
		System.out.println(this.user.getUserName() + " has logged in.");
	}
	
	pointcut printUser() : call(Collection<Persistable> PersistanceService.getObjects(..));
	after() returning: printUser() {
		System.out.println(this.user.getUserName() + " has used the persistance service.");
	}
	
	pointcut doctorsEyesOnlyData() :
		call(PatientFile Patient.getPatientFile());
	PatientFile around() : doctorsEyesOnlyData() {
		if (this.user.getRoles().contains(new Doctor())) {
			return proceed();
		}
		else {
			return new PatientFile();
		}
	}
}
