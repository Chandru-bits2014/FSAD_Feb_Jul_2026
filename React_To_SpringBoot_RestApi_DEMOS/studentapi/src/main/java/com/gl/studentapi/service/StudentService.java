package com.gl.studentapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gl.studentapi.model.Student;

@Service
public interface StudentService {
	
	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public void deleteStudentById(int id);
	public Student getStudentById(int id);
	public Student updateStudent(int id,Student student);


}
