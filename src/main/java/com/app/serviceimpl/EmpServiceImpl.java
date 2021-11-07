package com.app.serviceimpl;

import java.util.List;

import com.app.constants.QueryConstants;
import com.app.iservice.IEmpService;
import com.app.model.Emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements IEmpService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String saveEmp(Emp emp) {
		int i = jdbcTemplate.update(QueryConstants.SAVE_EMP, emp.getName(), emp.getEmail());
		return i + "row/s affeected";

	}

	@Override
	public String deleteEmp(int id) {
		int i = jdbcTemplate.update(QueryConstants.DELETE_EMP, id);

		return null;
	}

	@Override
	public Emp getEmpById(int id) {

		return jdbcTemplate.queryForObject(QueryConstants.GET_EMP, new Object[] { id },
				(rs, rowNum) -> new Emp(rs.getInt("id"), rs.getString("name"), rs.getString("email")));

	}

	@Override
	public String updateEmp(Emp emp) {
		return jdbcTemplate.update(QueryConstants.UPDATE_EMP, emp.getName(), emp.getId()) + "row/s affeected";
	}

	@Override
	public List<Emp> getAllEmp() {
		return jdbcTemplate.query(QueryConstants.GET_ALL_EMP,
				(rs, rowNum) -> new Emp(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
	}

}
