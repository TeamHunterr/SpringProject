package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Employee;
import com.journaldev.spring.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;

	
	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", this.employeeService.listEmployees());
		return "employee";
	}
	
	//For add and update person both
	@RequestMapping(value= "/employee/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("employee") Employee p){
		
		if(p.getEmployeeId() == 0){
			//new person, add it
			this.employeeService.addEmployee(p);
		}else{
			//existing person, call update
			this.employeeService.updateEmployee(p);
		}
		
		return "redirect:/employee";
		
	}
	
	@RequestMapping("/remove/{employeeId}")
    public String removePerson(@PathVariable("employeeId") int id){
		
        this.employeeService.removeEmployee(id);
        return "redirect:/employee";
    }
 
    @RequestMapping("/edit/{employeeId}")
    public String editPerson(@PathVariable("employeeId") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employee";
    }

}
