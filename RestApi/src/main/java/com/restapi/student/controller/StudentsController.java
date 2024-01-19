package com.restapi.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.student.entities.Students;
import com.restapi.student.service.StudentService;

@RestController
public class StudentsController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/student")
	public List<Students> getStudents()
	{
		List<Students> list= studentService.getAllStudents();
		return list;
	}
	
	@GetMapping("/student/{id}")
	public Students getStudents(@PathVariable("id") int id)
	{
		
		return this.studentService.getStudentsById(id);
		
	}
	
	@PostMapping("/student")
	public Students addStudent(@RequestBody Students students)
	{
		Students b= this.studentService.saveOrUpdate(students);
		return b;
	}
	
	@DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable("studentId") int studentId)
	{
		this.studentService.delete(studentId);
	}
	
	@PutMapping("/student/{studentId}")
	public Students updateStudent(@RequestBody Students students)
	{
		return this.studentService.saveOrUpdate(students);
		
	}
	
}
