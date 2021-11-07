package com.app.constants;

public class QueryConstants {

	public static final String SAVE_EMP = "INSERT INTO emplyee(name,email) values(?,?)";
	public static final String GET_EMP = "SELECT * FROM emplyee WHERE id=?";
	public static final String UPDATE_EMP = "UPDATE emplyee SET name=? WHERE id=?";
	public static final String DELETE_EMP = "DELETE FROM emplyee WHERE id=?";
	public static final String GET_ALL_EMP = "SELECT * FROM emplyee";

	public static final String SAVE_FOO = "INSERT INTO foo(name,email) values(:name,:email)";
	public static final String GET_FOO = "SELECT * FROM foo WHERE id=:id";
	public static final String UPDATE_FOO = "UPDATE foo SET name=:name,email=:email WHERE id=:id";
	public static final String DELETE_FOO = "DELETE FROM foo WHERE id=:id";
	public static final String GET_ALL_FOO = "SELECT * FROM foo";

}
