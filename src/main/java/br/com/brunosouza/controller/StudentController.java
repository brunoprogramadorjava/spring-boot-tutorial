package br.com.brunosouza.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunosouza.entity.Student;
import br.com.brunosouza.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = RequestMethod.GET )
	public Collection<Student> getAllStudent(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id){
		return studentService.getStudentById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeStudentById(@PathVariable("id") int id){
		studentService.removeStudentById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertStudent(@RequestBody Student student){
		studentService.insertStudent(student);
	}
	
	
}
