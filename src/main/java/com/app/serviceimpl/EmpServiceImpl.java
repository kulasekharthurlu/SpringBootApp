package com.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.app.iservice.IEmpService;
import com.app.model.Emp;

@Service
public class EmpServiceImpl implements IEmpService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String saveEmp(Emp emp) {
 
		 String query="insert into emplyee values(  "+emp.getId()+"','"+emp.getName()+"','"+emp.getEmail()+"')"; 
		 int i=jdbcTemplate.update(query);
		return i+"row/s affected";
	}

	@Override
	public String deleteEmp(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp getEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
