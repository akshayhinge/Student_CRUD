package com.student_crud.mvc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.student_crud.mvc.entities.ResultWrapper;
import com.student_crud.mvc.entities.Student;
import com.student_crud.mvc.repositories.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo studentRepo;
	
//	get all student data 
	public ResultWrapper getStudentsByPage(int pageNumber){
		try {
//			default pagesize is 5
			  Page<Student> all = studentRepo.findAll(PageRequest.of(pageNumber-1, 5));
			  ResultWrapper result=new ResultWrapper(
					
//					   currnet page number...it start with 0 so added one into it
					   all.getNumber()+1,
					   
//					   result list
					   all.getContent(),
					   
//					   total pages in db
					   all.getTotalPages(),
					   
//					   total records in db
					   all.getTotalElements());
			
			return result;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
//	add single student data
	public String addStudent(Student student) {
		try {
			Student saveStudentData = studentRepo.save(student);
			if(saveStudentData!=null) {
				return "Student data save successfully with student id :"+saveStudentData.getId();
			}else {
				return "Something went wrong please check all the parameters";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
//	update any data members of student data
	public Student updateStudentByID(int id, Student student) {
		try {
			Optional<Student> optionalData = studentRepo.findById((long) id);
			if (optionalData.isEmpty()) {
				return null;
			}
			Student oldStudentData=optionalData.get();
			if(student.getName()!=null) {
				oldStudentData.setName(student.getName());
			}
			if(student.getAddress()!=null) {
				oldStudentData.setAddress(student.getAddress());
			}
			if(student.getPhoneNumber()!=null) {
				oldStudentData.setPhoneNumber(student.getPhoneNumber());
			}
			return studentRepo.save(oldStudentData);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
//	delete student records by id
	public String deleteStudentbyID(int id) {
		try {
			studentRepo.deleteById((long) id);
			return "Student record deleted succesfully with id : "+id;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
