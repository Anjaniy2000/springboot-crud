package com.anjaniy.springbootcrud.controllers;

import com.anjaniy.springbootcrud.models.Student;
import com.anjaniy.springbootcrud.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

@RestController
@Tag(name = "Student REST Endpoint")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    //Get All The Students:
    @RequestMapping(value = "/students/", method = GET)
    @Operation(summary = "Returns All The Students", description = "With The GET Request, Get All The Students")
    public @ApiResponse(description = "Student Objects") ResponseEntity<List<Student>> getAllStudents(){
        return status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    //Get A Particular Student:
    @RequestMapping(value = "/students/{id}", method = GET)
    @Operation(summary = "Returns The Single Student By ID", description = "With The Student ID, Get A Particular Student")
    public @ApiResponse(description = "Student Object") ResponseEntity<Student> getStudentById(@Parameter(description = "Id Of The Student") @PathVariable("id") int id){
        return status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    //Create New Student:
    @RequestMapping(value = "/students/", method = POST)
    @Operation(summary = "Create New Student", description = "Create New Student With All The Fields.")
    public @ApiResponse(description = "Student Object") ResponseEntity<Student> createStudent(@RequestBody Student student){
        return status(HttpStatus.CREATED).body(studentService.createStudent(student));
    }

    //Update Existing Student:
    @RequestMapping(value = "/students/", method = PUT)
    @Operation(summary = "Update Student", description = "Update An Existing Student.")
    public @ApiResponse(description = "Student Object") ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return status(HttpStatus.OK).body(studentService.update(student));
    }

    //Delete Student:
    @RequestMapping(value = "/students/{id}", method = DELETE)
    @Operation(summary = "Delete Student", description = "Delete An Existing Student With The Student ID.")
    public void deleteStudent(@Parameter(description = "Id Of The Student") @PathVariable("id") int id){
        studentService.deleteById(id);
        ResponseEntity.status(HttpStatus.OK);
    }
}
