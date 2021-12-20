package com.app.iservice;

import com.app.model.Addres;

public interface IAddres {
	Addres findByUserId(int addresId,int userId);
	Addres saveAddres(Addres addres);

}
