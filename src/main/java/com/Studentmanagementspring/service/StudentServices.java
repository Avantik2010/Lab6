package com.Studentmanagementspring.service;

import java.util.List;

import com.Studentmanagementspring.entity.Student;

public interface StudentServices {
	
	
	public List<Student> findAll() ;
	public Student findById(int id);
	public void save (Student student);
	public void deleteById (int id);
	

}	

