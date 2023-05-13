package com.example.bootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootdemo.dto.Student;
import com.example.bootdemo.repository.StudentRepository;

@RestController
public class Controller {
	@Autowired
	StudentRepository sr;
	
	@PostMapping("/savedata")
	public String save(@RequestBody Student s) {
     sr.save(s);
		return "data saved successfully";
	}
	
	
	@GetMapping("/hi")
	public String m2() {
		return "get request is handled";
	}
	@DeleteMapping("/hi")
	public String m3() {
		return "delete request is handeled";
	}
	@PutMapping("/hi")
	public String m4() {
		return "Put request is handeled";
	}
	
		@GetMapping("/fetchdata")
		public Student fetchStudentById(@RequestParam int id) {
			Optional<Student>ou=sr.findById(id);
			Student s=ou.get();
			return s;
		
	}
		@GetMapping("/findstudentbyname")
		public List<Student> fetchStudentByName(@RequestParam String name){
			List<Student> students=sr.findByName(name);
			return students;
			
		}
		@GetMapping("/findallstudents")//url
		public List<Student> fetchAllStudents(){
			List<Student> students=sr.findAll();
			return students;
		}
		@GetMapping("/findstudentsbyagegreaterthan")
		public List<Student>fetchStudentByAgeGreaterThan(@RequestParam int age){
			List<Student>students=sr.findByAgeGreaterThan(age);
			return students;
		}
		@GetMapping("/findstudentsbyagelessthan")
		public List<Student>fetchStudentByAgeLessThan(@RequestParam int age){
			List<Student>students=sr.findByAgeLessThan(age);
			return students;
		}
		@DeleteMapping("/delete")//it is contain primary key so we cannot written in student repository
		public String deleteStudent(@RequestParam int id) {
			sr.deleteById(id);
			return "data deleted successfully";
		}
		@DeleteMapping("/deleteall")
		public String deleteAllStudents() {{
			
		}
			sr.deleteAll();
			return "Complete data deleted successfully";
		}
		@PutMapping("/update")
		public String updateStudent(@RequestBody Student s) {
			sr.save(s);
			return "data updated successfully";
		}
		@GetMapping("/fetchdatabyageequal")
		public List<Student> findStudentByAge(@RequestParam int age){
			return sr.findByAgeEquals(age);
		}
		@GetMapping("/fetchdatabyagegreaterthanequal")
		public List<Student> findStudentByAgeGreaterThanEqual(@RequestParam int age){
			return sr.findByAgeGreaterThanEqual(age);
		}
		@GetMapping("/fetchdatabyagelessthanequal")
		public List<Student> findStudentByAgeLessThanEqual(@RequestParam int age){
			return sr.findByAgeLessThanEqual(age);
		}
		@GetMapping("/fetchdatabetween")
		public List<Student> findStudentByAgeBetween(@RequestParam int age1, @RequestParam int age2){
			return sr.findByAgeBetween(age1,age2);
		}
}
