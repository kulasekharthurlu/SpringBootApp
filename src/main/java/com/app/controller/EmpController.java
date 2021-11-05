package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpController {

    // get emp by id 
    @RequestMapping("/getEmpById")
    
    public String getEmpById(int id) {
		return null;
    }


}
