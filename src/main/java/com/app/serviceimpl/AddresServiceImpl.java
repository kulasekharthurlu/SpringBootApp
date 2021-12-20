package com.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.iservice.IAddres;
import com.app.model.Addres;
import com.app.repo.AddresRepository;
@Service
public class AddresServiceImpl implements IAddres {
	
	@Autowired
	AddresRepository addresRepository ;

	@Override
	public Addres findByUserId(int addresId, int userId) {
		return  addresRepository.findByUserId(addresId, userId);
	}

	@Override
	public Addres saveAddres(Addres addres) {
		return addresRepository.save(addres);
	}

}
