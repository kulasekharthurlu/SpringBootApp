package com.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.iservice.IUser;
import com.app.model.Addres;
import com.app.model.User;
import com.app.responce.Responce;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUser iUser;

	@PostMapping("/save")
	public Responce<User> saveUser(@RequestBody User userFromUI) {
		User userFromDB = iUser.findByUserEmail(userFromUI.getEmail());
		 if(null==userFromDB) {
			    User result=iUser.saveUser(userFromUI);
				return new Responce<User>(HttpStatus.OK,result,"ok");
			}
			else {
				return new Responce<User>(HttpStatus.BAD_REQUEST,userFromUI," Email already exist");
			}

		 }
	
	@GetMapping("/get")
	public Responce<User> getUser(@RequestParam int id) {
		User result=iUser.getUser(id);
		if(result!=null)
			return new Responce<User>(HttpStatus.OK,result,"ok");
		else
			return new Responce<User>(HttpStatus.BAD_REQUEST,result,"not found");
	}    
	@PutMapping("/update")
	public Responce<User> updateUser(@RequestBody User userFromUI) {
		User userFromDB = iUser.getUser(userFromUI.getId());
	  //   Set<Addres> adresFromDB=userFromDB.getAddress();
	    
		if(null!=userFromDB) { 
			userFromDB.setEmail(userFromUI.getEmail()==null?userFromDB.getEmail():userFromUI.getEmail());
			userFromDB.setName(userFromUI.getName()==null?userFromDB.getName():userFromUI.getName());
        	User updatedUser=iUser.updateUser(userFromDB);
        	 
			return new Responce<User>(HttpStatus.OK,updatedUser,"ok");
		}
		else {
			return new Responce<User>(HttpStatus.BAD_REQUEST,null,"not found");
		}

	}
	@DeleteMapping("/delete")
	public Responce<?> deleteUser(@RequestParam int id) {
		User result=iUser.getUser(id);
		if(result!=null) {
			String message= iUser.deleteUser(id);
			return new Responce<User>(HttpStatus.OK,null,message);
		}
		else {
			return new Responce<User>(HttpStatus.BAD_REQUEST,result,"User not found whith Id : "+id);
		}
	}
	@GetMapping("/getall")
	public  Responce<List<User>> getAllUsers(){
		List<User> users =  iUser.getAllUsers();
		if(users.isEmpty())
			return new Responce<List<User>>(HttpStatus.BAD_REQUEST, users, "Data  is empty");
		else
			return new Responce<List<User>>(HttpStatus.ACCEPTED, users,"OK");
				
	}




}
