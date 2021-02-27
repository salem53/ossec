package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sip.ams.entities.*;
import com.sip.ams.repositories.StudentRepository;

import java.util.*;

@Controller
@RequestMapping("student")
public class StudentController {
	
	
	StudentRepository service;
	
	@Autowired   // injection de dependence
	public StudentController(StudentRepository s)
	{
		this.service = s;
	}
	
/*	@RequestMapping("list")
	@ResponseBody
	public String listStudents()
	{
		List<Student> ls= (List<Student>)service.findAll(); //CRUD : Display
		System.out.println(ls);
		return "Students List";
	}*/
	

	static ArrayList<Student> ls= new ArrayList<>();
	
	static {
		ls.add(new Student(23,"Ali"));
		ls.add(new Student(24,"Sarra"));
		ls.add(new Student(22,"Mohamed"));
	}
	
    @RequestMapping(value={"/","list"})
	public String listStudents(Model model)
	{
    	 	
    	model.addAttribute("students", ls);
    	
    	
		return "student/list";
	}
    
    @GetMapping("add")
   	public String formAddStudent()
   	{
   		return "student/add";
   	}
    
    @PostMapping("add")
    //@ResponseBody
   	public String saveStudent(@RequestParam("name")String name, @RequestParam("age")int age)
   	{
    	System.out.println("name = "+ name + " Age = "+age);
    	Student s = new Student(age,name);
    	ls.add(s);
   		return "redirect:list"; // nom de la route
    	
    	//model.addAttribute("students", ls);
    	//return "student/list";
   	}
}
