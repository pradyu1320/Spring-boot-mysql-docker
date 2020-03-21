package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.StudentRepository;
import com.example.demo.model.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}
	@PostMapping("/student/create")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentRepository.save(student);
	}
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable(value="id") int id) {
		return studentRepository.findById(id).orElseThrow(null);
	}
	@DeleteMapping("/student/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value="id") int student_id){
		Student student = studentRepository.findById(student_id).orElseThrow(null);
		studentRepository.delete(student);
		return ResponseEntity.ok().build();
	}
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable(value="id") int student_id,@Valid @RequestBody Student student) {
		Student stu = studentRepository.findById(student_id).orElseThrow(null);
		stu.setStudent_name(student.getStudent_name());
		stu.setStudent_class(student.getStudent_class());
		stu.setMarks(student.getMarks());
		Student update = studentRepository.save(stu);
		return update;
	}
	
}
