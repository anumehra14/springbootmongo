package com.etutor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.etutor.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>

{

	 public List<Student> findByName(String name);
	 //using and operator 
	 public List<Student> findByNameAndMail(String name, String mail);
	 //using or operator
	 public List<Student> findByNameOrMail(String name, String mail);
		
}
