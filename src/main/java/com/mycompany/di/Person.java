package com.mycompany.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	
	private String name = "Kumar D";
	private int age = 77;
	private float height = 1.99f;
	private boolean isProgrammer = true;

	// Use @Autowired with a field
	@Autowired
	private Address address;

	public Address getAddress() {
		return address;
	}

	// Since Address object gets autowired, you
	// don't need this setter method anymore.
	//
	// public void setAddress(Address address) {
	// this.address = address;
	// }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isProgrammer() {
		return isProgrammer;
	}

	public void setProgrammer(boolean isProgrammer) {
		this.isProgrammer = isProgrammer;
	}

}
