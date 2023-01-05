package com.student_crud.mvc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_crud.mvc.dao.StudentDao;
import com.student_crud.mvc.entities.ResultWrapper;
import com.student_crud.mvc.entities.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public ResultWrapper getAllStudent(int pageNumber){
		return studentDao.getStudentsByPage(pageNumber);
	}
	
	public String addStudent(Student student) {
		return studentDao.addStudent(student);
	}
	
	public Student updateStudentByID(int id,Student student) {
		return studentDao.updateStudentByID(id, student);
	}
	
	public String deleteStudentbyID(int id) {
		return studentDao.deleteStudentbyID(id);
	}
}
