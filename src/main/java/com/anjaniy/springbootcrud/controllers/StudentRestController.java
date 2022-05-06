package com.anjaniy.springbootcrud.controllers;

import com.anjaniy.springbootcrud.models.Student;
import com.anjaniy.springbootcrud.repository.StudentRepo;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//For Delete Method:
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

@RestController
@Tag(name = "Student REST Endpoint")
public class StudentRestController {

    @Autowired
    private StudentRepo repo;

    //Get All The Students:
    @RequestMapping(value = "/students/", method = RequestMethod.GET)
    @Operation(summary = "Returns All The Students", description = "With The GET Request, Get All The Students")
    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    //Get A Particular Student:
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public @ApiResponse(description = "Student Object") Student getSingleStudent(@Parameter(description = "Id Of The Student") @PathVariable("id") int id){
        return repo.findById(id).get();
    }

    //Create New Student:
    @RequestMapping(value = "/students/", method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student){
        return repo.save(student);
    }

    //Update Existing Student:
    @RequestMapping(value = "/students/", method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student){
        return repo.save(student);
    }

    //Delete Student:
    @Hidden
    @RequestMapping(value = "/students/{id}", method = DELETE)
    public void deleteStudent(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
