package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Emp;
import com.app.serviceimpl.EmpServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpServiceImpl empServiceImpl;

    // get emp by id 
    @RequestMapping("/getEmpById")
    public String getEmpById(int id) {
		return null;
    }
    @PostMapping("/save")
    public String saveEmp(@RequestBody Emp emp) {
    	 String resutl= empServiceImpl.saveEmp(emp);
		return resutl;
    	
    }


}
