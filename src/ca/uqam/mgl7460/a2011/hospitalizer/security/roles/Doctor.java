package ca.uqam.mgl7460.a2011.hospitalizer.security.roles;

public class Doctor extends Role {
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if ((obj instanceof Doctor)) {
			isEqual = true ; 
		}
		return isEqual;
	}
}
