package com.java8.features;

public class StudentMap {

	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "StudentMap [" + (studentName != null ? "studentName=" + studentName : "") + "]";
	}
	
	
}
