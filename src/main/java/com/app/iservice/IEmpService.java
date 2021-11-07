package com.app.iservice;

import java.util.List;

import com.app.model.Emp;

public interface IEmpService {
	public String saveEmp(Emp emp);

	String deleteEmp(int id);

	Emp getEmpById(int id);

	String updateEmp(Emp emp);
	List<Emp> getAllEmp();


}
