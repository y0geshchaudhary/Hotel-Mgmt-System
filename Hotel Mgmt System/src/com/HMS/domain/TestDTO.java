package com.HMS.domain;

public class TestDTO {

	private String name;
	private int age;
	private long phn;
	private String address;
	private String sports;
	
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public long getPhn() {
		return phn;
	}
	public String getAddress() {
		return address;
	}
	public String getSports() {
		return sports;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhn(long phn) {
		this.phn = phn;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	@Override
	public String toString() {
		return "TestDTO [name=" + name + ", age=" + age + ", phn=" + phn
				+ ", address=" + address + ", sports=" + sports + "]";
	}
	
	
	
}

