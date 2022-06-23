package com.curso.jdbc.models.entity;

public class Employee {
	private int id;
	private String nombre;
	private String apellido;
	private int age;
	private double salario;
	
	
	
	public Employee(int id, String nombre, String apellido, int age, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.age = age;
		this.salario = salario;
	}
	
	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
