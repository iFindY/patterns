package main.java.de.arkadi.creational.factory.conc;

import java.util.Calendar;

public class FactoryEverydayDemo {

	public static void main(String args []) {
		
		Calendar cal = Calendar.getInstance();
		// factory creating different objects
		// Calendar cal = Calendar.get
		
		System.out.println(cal);

		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
	}
	
}
