package com.curso.jdbc.models.entity;

public class Address {
	
	private int id ;
	private String street;
	private int pc;
	private int employee_id;
	private String number;
	public Address(String street, int pc, int employee_id, String number) {
		super();
		this.street = street;
		this.pc = pc;
		this.employee_id = employee_id;
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
