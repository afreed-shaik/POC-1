package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.student.domain.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudents")
	public Student addStudent(@RequestBody Student stu) {
		return studentService.addStudent(stu);
	}
	
	@GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getAllStudents (
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "5") Integer pageSize) 
    {
        List<Student> list = studentService.getAllStudents(pageNo, pageSize);
 
        return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
	
	
	@GetMapping("/student/{studId}")
	public Optional<Student> getStudent(@PathVariable("studId") Integer studId) {
		return studentService.getStudent(studId);
	}
	
	
	@DeleteMapping("/student/{studId}")
	public void deleteStudent(@PathVariable("studId") Integer studId) {
		studentService.deleteStudent(studId);
	}
	
	//Update a Ticket
	@PutMapping("/student/{studId}/{newEmail}/{newPhone}")
	public Student updateStudent(@PathVariable("studId") Integer studId,
			                   @PathVariable("newEmail") String newEmail,
			                   @PathVariable("newPhone") String newPhone) {
		return studentService.updateStudent(studId, newEmail, newPhone);
	}
}
