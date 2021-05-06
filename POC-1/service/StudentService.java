package com.student.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.domain.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentData;
	
	 public Student addStudent(Student student) {
		return studentData.save(student);
		
	}
	
	public List<Student> getAllStudents(Integer pageNo, Integer pageSize)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);
 
        Page<Student> pagedResult = studentData.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Student>();
        }
    }

	public void deleteStudent(Integer studId) {
		studentData.deleteById(studId);
		
	}

	

	public Student updateStudent(Integer studId, String newEmail, String newPhone) {
		Student stu = studentData.findById(studId).orElse(new Student());
		stu.setStudEmail(newEmail);
		stu.setStudPhoneNo(newPhone);
		return studentData.save(stu);
	}

	public Optional<Student> getStudent(Integer studId) {
		// TODO Auto-generated method stub
		return studentData.findById(studId);
	}
}
