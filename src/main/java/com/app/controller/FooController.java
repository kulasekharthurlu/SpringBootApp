package com.app.controller;

import java.util.List;

import com.app.iservice.IFooService;
import com.app.model.Foo;
import com.app.responce.Responce;

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

@RestController
@RequestMapping("/foo")
@CrossOrigin("*")
public class FooController {

    @Autowired
    private IFooService fooService;

    @PostMapping("/save")
    public  Responce<Foo> saveFoo(@RequestBody Foo foo){
       return new Responce<>(HttpStatus.OK,foo,fooService.saveFoo(foo));
    }
    @PutMapping("/update")
    public  Responce<Foo> updateFoo(@RequestBody Foo foo){
        return new Responce<>(HttpStatus.OK,foo,fooService.saveFoo(foo));
    }
    @GetMapping("/get")
    public Responce<Foo>  getFoo(@RequestParam int id){
        return new Responce<>(HttpStatus.OK,fooService.getFoo(id),null); 
    }
    @DeleteMapping("/delete")
    public  Responce<Foo> deleteFoo(@RequestParam int id){
        return  new Responce<>(HttpStatus.OK,null,fooService.deleteFoo(id));
    }
    @GetMapping("/getall")
    public Responce<List<Foo>> getAllFoo(){
        return new Responce<>(HttpStatus.OK, fooService.getAllFoo(),null);
    }

}
