package com.gl.studentapi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.studentapi.exception.StudentNotFoundException;
import com.gl.studentapi.model.Student;
import com.gl.studentapi.repository.StudentRepository;

import jakarta.transaction.Transactional;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    public StudentRepository studentRepository;
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	public void deleteStudentById(int id)
	{
		studentRepository.deleteById(id);
	}
	/*public Student getStudentById(int id)
	{
		return studentRepository.findById(id).get();
	}*/
	public Student getStudentById(int id)
	{
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student Not Found with Id "+id));
	}
	public Student updateStudent(int id,Student student)
	{
		Student studentU;
		//studentU = getStudentById(id);
		studentU = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student Not Found with Id "+id));
		studentU.setFirstName(student.getFirstName());
		studentU.setLastName(student.getLastName());
		studentU.setMarks(student.getMarks());
		
		return studentRepository.save(studentU);
		
	}

   

      
    	
         
    
   

}
