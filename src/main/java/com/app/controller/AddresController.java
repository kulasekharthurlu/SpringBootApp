package com.app.controller;

import java.util.function.BinaryOperator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.iservice.IAddres;
import com.app.model.Addres;
import com.app.responce.Responce;
import com.app.serviceimpl.AddresServiceImpl;

@RestController
@RequestMapping("/addres")
public class AddresController {

	@Autowired
	private	IAddres addresService;


	@PutMapping("/updateuseraddres")
	public Responce<Addres> updateAddres(@RequestParam int userId,@RequestBody Addres addres) {
		Addres resultFromDB=addresService.findByUserId(addres.getId(), userId);
		if(null!=resultFromDB) {
		Addres rels=	getAddres.apply(resultFromDB, addres);
	    Addres updatedAddres= addresService.saveAddres(rels);
            return new Responce<Addres>(HttpStatus.OK,updatedAddres,"success");
		} 
		return new Responce<Addres>(HttpStatus.BAD_REQUEST,addres,"bad request");

	}
	BinaryOperator<Addres> getAddres=(e1,e2)->{
		e1.setAddressType(e2.getAddressType()==null?e1.getAddressType():e2.getAddressType());
		e1.setPinCode(e2.getPinCode()==0?e1.getPinCode():e2.getPinCode());
		e1.setState(e2.getState()==null?e1.getState():e2.getState());
		e1.setStreetName(e2.getStreetName()==null?e1.getStreetName():e2.getStreetName());
		return e1;
	};


}

