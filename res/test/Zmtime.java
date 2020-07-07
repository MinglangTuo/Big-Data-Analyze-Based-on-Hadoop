package com.annn.test;



public class Zmtime {

	private String name;
	private int times;
	
	public Zmtime() {
		super();
		this.name = "";
		this.times = 0;
	}
	public Zmtime(String name, int times) {
		super();
		this.name = name;
		this.times = times;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
	
}
