package com.app.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.constants.QueryConstants;
import com.app.iservice.IFooService;
import com.app.model.Foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements IFooService {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public String saveFoo(Foo foo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", foo.getName());
		paramMap.put("email", foo.getEmail());
		int i = namedParameterJdbcTemplate.update(QueryConstants.SAVE_FOO, paramMap);
		return i + "row/s affected";
	}

	@Override
	public String updateFoo(Foo foo) {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", foo.getId());
		paramMap.put("id", foo.getName());
		paramMap.put("name", foo.getName());
		paramMap.put("email", foo.getEmail());
		namedParameterJdbcTemplate.update(QueryConstants.UPDATE_FOO, paramMap);
		return "update Success";
	}

	@Override
	public String deleteFoo(int id) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		int i = namedParameterJdbcTemplate.update(QueryConstants.DELETE_FOO, paramMap);
		return i + "row/s affected";
	}

	@Override
	public Foo getFoo(int id) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(QueryConstants.GET_FOO, paramMap, (rs, rowNum) -> {
			Foo foo = new Foo();
			foo.setId(rs.getInt("id"));
			foo.setName(rs.getString("name"));
			foo.setEmail(rs.getString("email"));
			return foo;
		});

	}

	@Override
	public List<Foo> getAllFoo() {
		List<Foo> foos = new ArrayList<>();
		namedParameterJdbcTemplate.query(QueryConstants.GET_ALL_FOO, (rs, rowNum) -> {
			Foo foo = new Foo();
			foo.setId(rs.getInt("id"));
			foo.setName(rs.getString("name"));
			foo.setEmail(rs.getString("email"));
			foos.add(foo);
			return foo;
		});
		return foos;
	}
}
