package com.gl.studentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.studentapi.model.Student;
import com.gl.studentapi.service.StudentService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class StudentController {

	//private static final int ResponseEntity = 0;
	@Autowired
	StudentService studentService;
	
	/*@GetMapping(value="/allStudents")
	public List <Student> getAllStudents()
	{
		return studentService.getAllStudents();
	} */
	@GetMapping(value="/allStudents")
	public ResponseEntity <List <Student>> getAllStudents()
	{
		return ResponseEntity.ok(studentService.getAllStudents());
		
	}
	
	
	/*@GetMapping(value="/allStudents/{studId}")
	public Student getStudentById(@PathVariable int studId)
	{
		return studentService.getStudentById(studId);
	}*/
	@GetMapping(value="/allStudents/{studId}")
	public ResponseEntity <Student> getStudentById(@PathVariable int studId)
	{
		return ResponseEntity.ok(studentService.getStudentById(studId));
	}
	
	/*@PostMapping(value="/allStudents")
	public String addStudentDetails(@RequestBody Student student)
	{
		studentService.saveStudent(student);
		return "Student Details Added Successfully...";
	}*/
	@PostMapping(value="/allStudents")
	public ResponseEntity <Student> addStudentDetails(@RequestBody Student student)
	{
		//studentService.saveStudent(student);
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	
	/*@PutMapping(value="/allStudents")
	public String updateStudentDetails(@RequestBody Student student,@RequestParam int id)
	{
		studentService.updateStudent(student, id);
		return "Student Details Updated Successfully...";
	}*/
	
	/*
	@PutMapping(value="/allStudents/{studId}")
	public String updateStudentDetails(@RequestBody Student student,@PathVariable int studId)
	{
		studentService.updateStudent(student, studId);
		return "Student Details Updated Successfully...";
	}*/
	@PutMapping(value="/allStudents/{studId}")
	public ResponseEntity <Student> updateStudentDetails(@PathVariable int studId,@RequestBody Student student)
	{
		return ResponseEntity.ok(studentService.updateStudent(studId,student));
	}
	
	@DeleteMapping(value="/allStudents/{studId}")
	public ResponseEntity <String> deleteStudentById(@PathVariable int studId)
	{
		studentService.deleteStudentById(studId);
		return ResponseEntity.ok("Student Details Deleted Successfully");
		//return 
	}
}
