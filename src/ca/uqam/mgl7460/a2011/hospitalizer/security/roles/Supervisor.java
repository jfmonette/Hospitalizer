package ca.uqam.mgl7460.a2011.hospitalizer.security.roles;

public class Supervisor extends Role {
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if ((obj instanceof Supervisor)) {
			isEqual = true ; 
		}
		return isEqual;
	}
}
