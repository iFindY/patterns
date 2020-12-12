package main.java.de.arkadi.structural.adapter.custom.ldap;

import main.java.de.arkadi.structural.adapter.custom.Employee;

// should implement interface
public class EmployeeAdapterLdap implements Employee {

	private final EmployeeLdap instance;
	
	public EmployeeAdapterLdap(EmployeeLdap instance) {
		// we take the instance and wrap it with this adapter class
		this.instance = instance;
	}
	
	@Override
	public String getId() {
		return instance.getCn();
	}

	@Override
	public String getFirstName() {
		// other naming
		return instance.getGivenName();
	}

	@Override
	public String getLastName() {
		// other naming
		return instance.getSurname();
	}

	@Override
	public String getEmail() {
		return instance.getMail();
	}

	public String toString() {
		return "ID: " + instance.getCn();
	}
	
}
