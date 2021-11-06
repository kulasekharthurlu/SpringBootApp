package com.app.constants;

public class QueryConstants {
 
	public static String SAVE_EMP="INSERT INTO emplyee(name,email) values(?,?)";
	public static String GET_EMP="SELECT * FROM emplyee WHERE id=?";
	public static String UPDATE_EMP="UPDATE emplyee SET name=? WHERE id=?";
	public static String DELETE_EMP="DELETE FROM emplyee WHERE id=?";
	public static String GET_ALL_EMP="SELECT * FROM emplyee";
	
	public static String SAVE_FOO="INSERT INTO emplyee(name,email) values(:name,:email)";
	public static String GET_FOO="SELECT * FROM foo WHERE id=:id";
	public static String UPDATE_FOO="UPDATE foo SET name=:name WHERE id=:id";
	public static String DELETE_FOO="DELETE FROM foo WHERE id=:id";
	public static String GET_ALL_FOO="SELECT * FROM foo";
	
}
