package com.etutor.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etutor.entity.Student;
import com.etutor.service.StudentService;

@RestController
@RequestMapping("/api/etutor")
@CrossOrigin(origins="http://localhost:3000")
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping("/getstudents")
	public List<Student> getStudentsDetails()
	{
	
		return service.findByAll();
	}
	@PostMapping("/saveStudent")
	public Student  createStudent(@RequestBody Student s)
	{
		return service.saveStudent(s);
	}
	
	
	@GetMapping("/getbyid/{id}")
	public Optional<Student> getStudentById(@PathVariable String id)
	{
		return service.getById(id);
	}
	@GetMapping("/findbyname/{name}")
	public List<Student> findByName(@PathVariable String name)
	{
		return service.findStudentByName(name);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudentData(@PathVariable String id)
	{
		service.deleteStudent(id);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudentdata(@RequestBody Student s)
	{
		//if we provide value for id field it will update existing record 
		//if we do not provide id it will create new 
		return service.saveStudent(s);
	}
	//using & operator 
	//search by name and email both 
	@GetMapping("/findbynameandmail")
	public List<Student> findbynameandmail(@RequestParam String name ,@RequestParam String mail)
	{
		System.out.println("sdsddsdds");
		return service.fingByNameAndMail(name,mail); 
		
	}
	//using or operator 
	@GetMapping("/findbynameormail")
	public List<Student> findbynameormail(@RequestParam String name ,@RequestParam String mail)
	{
		
		return service.fingByNameOrMail(name,mail); 
	}
	
	//pagination 
	
	@GetMapping("/getstudentsPageWise")
	public List<Student> getStudentsDetailsPageWise(@RequestParam int pageNo,@RequestParam int pageSize)
	{
	
		return service.getAllWithPagination(pageNo,pageSize);
	}
	
}
