package ca.uqam.mgl7460.a2011.hospitalizer.aspects.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;

import ca.uqam.mgl7460.a2011.hospitalizer.aspects.security.*;
import ca.uqam.mgl7460.a2011.hospitalizer.data.*;
import ca.uqam.mgl7460.a2011.hospitalizer.application.*;

public aspect Logging {
	private User user = new User();
	
	pointcut authenticate() : call(User SecurityService.authenticate(..));
	after() returning(User user) : authenticate() {
		this.user = user;
	}
	
	pointcut callingAService() : 
		call(* PersistanceService.*(..))
		|| call(* SecurityService.*(..));
	after(): callingAService() {
		StringBuilder str = new StringBuilder();
		str.append("User ");
		str.append(this.user.getUserName());
		str.append(" has used the following service : ");
		str.append(thisJoinPoint.getTarget().getClass().getCanonicalName());
		str.append("\n");
		writeToFile(str.toString());
		
	}
	
	private void writeToFile(String message) {
    	try {
    		FileWriter fileStream = new FileWriter("./data/logging/log.txt", true);
			BufferedWriter out = new BufferedWriter(fileStream);
			out.write(message);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
