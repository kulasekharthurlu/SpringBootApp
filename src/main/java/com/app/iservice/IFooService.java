package com.app.iservice;

import java.util.List;

import com.app.model.Foo;

public interface IFooService {
	
	String saveFoo(Foo foo);
	String updateFoo(Foo foo);
	String deleteFoo(int id);
	Foo getFoo(int id);
	List<Foo> getAllFoo();

}
