package org.tut5.microservice.tpo.student.model;

public class Student {
	private long id;
	private String name;
	private String branch;
	private int year;
	private boolean blacklisted;
	private float pointer;
	private boolean placed;
	private String placedAt;
	
	public Student(long id, String name, String branch, int year, boolean blacklisted, float pointer, boolean placed,
			String placedAt) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.year = year;
		this.blacklisted = blacklisted;
		this.pointer = pointer;
		this.placed = placed;
		this.placedAt = placedAt;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isBlacklisted() {
		return blacklisted;
	}
	public void setBlacklisted(boolean blacklisted) {
		this.blacklisted = blacklisted;
	}
	public float getPointer() {
		return pointer;
	}
	public void setPointer(float pointer) {
		this.pointer = pointer;
	}
	public boolean isPlaced() {
		return placed;
	}
	public void setPlaced(boolean placed) {
		this.placed = placed;
	}
	public String getPlacedAt() {
		return placedAt;
	}
	public void setPlacedAt(String placedAt) {
		this.placedAt = placedAt;
	}
	
	
}
