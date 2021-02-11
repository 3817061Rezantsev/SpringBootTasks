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
	@Size(min = 2, message = "The name must be more than 2 characters.")
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
		String res = firstName;
		res = secondName.equals("") ? res + " null" : res + " " + secondName;
		res = lastName.equals("") ? res + " null" : res + " " + lastName;
		res += " " + age;
		res += " " + salary;
		res = workplace.equals("") ? res + " null" : res + " " + workplace;
		res = email.equals("") ? res + " null" : res + " " + email;
		return res;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
