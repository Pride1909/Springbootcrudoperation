package com.example.bootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootdemo.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>//student is table name , for JpaRepository we pass 2 argument 
//i.e.table name(e.g.student)and datatype of primary key (e.g.integer)
{
 List<Student>findByName(String name);
 
 List<Student> findByAge(int age);

 List<Student> findByAgeGreaterThan(int age);

 List<Student> findByAgeLessThan(int age);//if data is not primary key then write in student repository
 
 List<Student> findByAgeEquals(int age);
 
 List<Student> findByAgeGreaterThanEqual(int age);
 
 List<Student> findByAgeLessThanEqual(int age);
 
 List<Student> findByAgeBetween(int age1,int age2);
 
 List<Student> findByGrade(String grade);

 List<Student> findByAddress(String address);
}
