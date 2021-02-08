package com.example.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Form {
	private String firstName;
	private String lastName;
	private String secondName;
	private int age;
	private int salary;
	private String workplace;
	private String email;

	@NotNull
	@Size(min = 2, message = "First Name must more then 2 characters")
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

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@NotNull
	@Min(value = 18, message = "Age should not be less than 18")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return firstName + " " + secondName + " " + lastName + " " + age + " " + salary + " " + workplace + " " + email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
