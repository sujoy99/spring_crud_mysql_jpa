package org.itbl.crud.controller;

import org.itbl.crud.model.Employee;
import org.itbl.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	// Display list of employees
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		
		return "index";
	}
	
	@RequestMapping(value="/newEmployee")
	public String saveEmployee(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		return "add_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//		System.out.println(employee);
		employeeService.saveEmployee(employee);
		return "redirect:/";
		
	}
}
