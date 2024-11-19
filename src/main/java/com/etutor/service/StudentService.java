package com.etutor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.etutor.entity.Student;
import com.etutor.repository.StudentRepository;

@Service
public class StudentService 
{
    @Autowired
	StudentRepository sr;

public Student saveStudent(Student s)
{
	return sr.save(s);
	
}
public List<Student> findByAll()
{
	return sr.findAll();
}

public Optional<Student> getById(String id)
{
	return sr.findById(id);
}

public void deleteStudent(String id)
{
	  sr.deleteById(id);
}

public List<Student> findStudentByName(String name)
{
	return sr.findByName(name);
}

public List<Student> fingByNameAndMail(String name,String mail){
	

 return sr.findByNameAndMail(name,mail);
}

public List<Student> fingByNameOrMail(String name,String mail){
	

	 return sr.findByNameOrMail(name,mail);
	}
//pageno   skip  limit 
// 1        0     10
// 2        10    10
//3         20    10
//pageno-1*pagesize
public List<Student> getAllWithPagination(int pageNo, int pageSize) {
	PageRequest p=PageRequest.of(pageNo-1, pageSize);
	
	return sr.findAll(p).getContent();
}
}
