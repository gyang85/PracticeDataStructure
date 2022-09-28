package com.java8.features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApis {

	
	public static List<Student> filter(List<Student> studentList){
		return studentList.stream().filter(student-> student.getId()>2).collect(Collectors.toList());
	}
	
	public static List<Student> sorting(List<Student> studentList){
		return studentList.stream().sorted(Comparator.comparing(Student::getStudentName)).collect(Collectors.toList());
	}
	
	public static List<StudentMap> map(List<Student> studentList){
		return studentList.stream().map(student -> {
			StudentMap studentMap = new StudentMap();
			studentMap.setStudentName(student.getStudentName());
			return studentMap;
		}).collect(Collectors.toList());
	}
	
	public static Student findLast(List<Student> studentList) {
		return studentList.stream().sorted(Comparator.comparing(Student::getStudentName).reversed()).collect(Collectors.toList()).get(studentList.size()-1);
	}
	
	public static void main (String args[]) {
		List<Student> studentList = new ArrayList<>();
		Student student1 = new Student();
		student1.setId(1);
		student1.setStudentName("Gyanendra");
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setStudentName("Ram");
		
		Student student3 = new Student();
		student3.setId(3);
		student3.setStudentName("Ravi");
		
		Student student4 = new Student();
		student4.setId(4);
		student4.setStudentName("Arun");
		
		
		studentList.add(student3);
		studentList.add(student1);
		studentList.add(student4);
		studentList.add(student2);
		
		System.out.println("Original List ->" + studentList.toString());
		System.out.println("filtered List ->" + filter(studentList));
		System.out.println("Sorted List ->" + sorting(studentList));
		System.out.println("Sorted List ->" + map(studentList));
		System.out.println("Sorted List ->" + findLast(studentList));
	}
}
