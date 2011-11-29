package ca.uqam.mgl7460.a2011.hospitalizer.aspects.security;

import ca.uqam.mgl7460.a2011.hospitalizer.application.*;
import ca.uqam.mgl7460.a2011.hospitalizer.aspects.security.roles.*;
import ca.uqam.mgl7460.a2011.hospitalizer.domain.*;

public aspect Security {
	private User user = new User();
	
	pointcut authenticate() : call(User SecurityService.authenticate(..));
	after() returning(User user) : authenticate() {
		this.user = user;
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
