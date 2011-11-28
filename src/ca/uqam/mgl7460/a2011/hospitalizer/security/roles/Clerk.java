package ca.uqam.mgl7460.a2011.hospitalizer.security.roles;

public class Clerk extends Role {
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if ((obj instanceof Clerk)) {
			isEqual = true ; 
		}
		return isEqual;
	}
}
