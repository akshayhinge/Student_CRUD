package com.student_crud.mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_crud.mvc.entities.Student;
import com.student_crud.mvc.services.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("{page}")
	public ResponseEntity<?> getStudentsbypage(@PathVariable("page") int pageNumber){
		if(pageNumber<=0 || pageNumber>200) return new ResponseEntity<String>("page number must be greter than 0 and less then 200",HttpStatus.BAD_REQUEST);
		return ResponseEntity.ok(studentService.getAllStudent(pageNumber)); 
	}
	
	@PostMapping("")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateStudentByid(@PathVariable("id") int studentID,@RequestBody Student student){
		if(studentID <=0 ) return new ResponseEntity<String>("Student ID must be greter than 0",HttpStatus.BAD_REQUEST);
		Student result = studentService.updateStudentByID(studentID, student);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}
		return new ResponseEntity<String>("Something went wrong! Please check student ID or Student all fields? ",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudentByID(@PathVariable("id") int studentID){
		if(studentID <=0) return new ResponseEntity<String>("Student ID must be greter than 0 ",HttpStatus.BAD_REQUEST);
	return ResponseEntity.ok(studentService.deleteStudentbyID(studentID));
	}
}
