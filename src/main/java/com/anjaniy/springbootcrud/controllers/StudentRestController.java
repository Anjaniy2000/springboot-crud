package com.anjaniy.springbootcrud.controllers;

import com.anjaniy.springbootcrud.models.Student;
import com.anjaniy.springbootcrud.services.StudentService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//For Delete Method:
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

@RestController
@Tag(name = "Student REST Endpoint")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    //Get All The Students:
    @RequestMapping(value = "/students/", method = RequestMethod.GET)
    @Operation(summary = "Returns All The Students", description = "With The GET Request, Get All The Students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    //Get A Particular Student:
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public @ApiResponse(description = "Student Object") ResponseEntity<Student> getStudentById(@Parameter(description = "Id Of The Student") @PathVariable("id") int id){
        return status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    //Create New Student:
    @RequestMapping(value = "/students/", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return status(HttpStatus.CREATED).body(studentService.createStudent(student));
    }

    //Update Existing Student:
    @RequestMapping(value = "/students/", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return status(HttpStatus.OK).body(studentService.update(student));
    }

    //Delete Student:
//    @Hidden
    @RequestMapping(value = "/students/{id}", method = DELETE)
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteById(id);
        ResponseEntity.status(HttpStatus.OK);
    }
}
