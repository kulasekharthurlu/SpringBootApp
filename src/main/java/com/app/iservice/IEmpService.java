package com.app.iservice;

import com.app.model.Emp;

public interface IEmpService {
	public String saveEmp(Emp emp);
	String deleteEmp(int id);
	

}
