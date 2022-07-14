package com.Studentmanagementspring.controller;

import java.security.Principal;
import java.util.List;

import com.Studentmanagementspring.entity.Student;
import com.Studentmanagementspring.service.StudentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentServices studentService;

	@RequestMapping("/list")
	public String listbooks(Model model) {

		List<Student> students = studentService.findAll();
		model.addAttribute("Students", students);
		return "list-students";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		Student student = studentService.findById(id);
		model.addAttribute("Student", student);
		return "student-form";
	}

	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("Id") int id) {

		studentService.deleteById(id);

		return "redirect:/students/list";
	}

	@RequestMapping("/showFormForAdd")
	public String addstudent(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "student-form";

	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

	@PostMapping("/save")
	public String saveorupdatestudent(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname , @RequestParam("course") String course,  
			@RequestParam("country") String country) {
		System.out.println(id);
		Student thestudent;
		if (id != 0) {
			thestudent = studentService.findById(id);
			thestudent.setFirstName(firstname);
			thestudent.setLastName(lastname);
			thestudent.setCourse(course);
			thestudent.setCountry(country);

		} else {
			thestudent = new Student(firstname, lastname, course, country);

		}
		studentService.save(thestudent);
		return "redirect:/students/list";
	}

}