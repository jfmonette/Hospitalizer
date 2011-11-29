package ca.uqam.mgl7460.a2011.hospitalizer.aspects.security;

import java.util.*;

import ca.uqam.mgl7460.a2011.hospitalizer.aspects.security.roles.Role;
import ca.uqam.mgl7460.a2011.hospitalizer.data.Persistable;

public class User extends Persistable {
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private Collection<Role> roles = new ArrayList<Role>();
	
	public User() {};
	
	public User(String userName, String firstName, String lastName, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void addRole(Role role) {
		this.roles.add(role);
	}
}
