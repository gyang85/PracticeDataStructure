package com.java8.features;

public class Student {
	private long id;
	private String studentName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", " + (studentName != null ? "studentName=" + studentName : "") + "]";
	}

}
