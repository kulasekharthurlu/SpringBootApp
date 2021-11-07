package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.app.model.Emp;
import com.app.serviceimpl.EmpServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmpController {

  @Autowired
  EmpServiceImpl empServiceImpl;

  // get emp by id
  @RequestMapping("/get")
  public String getEmpById(@RequestParam int id) {
    Emp emp = empServiceImpl.getEmpById(id);
    return emp.toString();
  }

  @PostMapping("/save")
  public String saveEmp(@RequestBody Emp emp) {
    empServiceImpl.saveEmp(emp);
    return "Emp saved successfully";

  }

  @GetMapping("/getAll")
  public List<Emp> getAllEmp() {
    List<Emp> empList = empServiceImpl.getAllEmp();
    return empList;
  }

  @DeleteMapping("/delete")
  public String deleteEmp(@RequestParam int id) {
    empServiceImpl.deleteEmp(id);
    return "Emp deleted successfully";
  }

  @PutMapping("/update")
  public String updateEmp(@RequestBody Emp emp) {
    empServiceImpl.updateEmp(emp);
    return "Emp updated successfully";
  }

}
