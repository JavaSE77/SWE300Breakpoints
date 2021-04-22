package xyz.javase.swe300.breakpoints;

import java.time.Year;

public class NameRecord {

	String state = null;
	int year = 0;
	String name = null;
	int number = 0;
	String gender = null;
	
	/**
	 * @param String state, int year, String name, int number, String gender
	 * */
	public NameRecord (String state, int year, String name, int number, String gender) {
		this.state = state;
		this.year = year;
		this.name = name;
		this.number = number;
		this.gender = gender;
	}
	
	
	public String getState() {
		return state;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCount() {
		return number;
	}
	
	public String getGender( ) {
		return gender;
	}
	
	@Override
	public String toString() {	
		return state + " | " + year + " | " + name + " | " + number + " | " + gender;
	}
	
	
}
