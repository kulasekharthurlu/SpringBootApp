package com.app.controller;

import java.util.List;

import com.app.iservice.IFooService;
import com.app.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FooController {

    @Autowired
    private IFooService fooService;

    @PostMapping("/save")
    public String saveFoo(@RequestBody Foo foo){
       return fooService.saveFoo(foo);
    }
    @PutMapping("/update")
    public String updateFoo(@RequestBody Foo foo){
        return fooService.updateFoo(foo);
    }
    @GetMapping("/get")
    public Foo getFoo(@RequestParam int id){
        return fooService.getFoo(id);
    }
    @DeleteMapping("/delete")
    public String deleteFoo(@RequestParam int id){
        return fooService.deleteFoo(id);
    }
    @GetMapping("/getall")
    public List<Foo> getAllFoo(){
        return fooService.getAllFoo();
    }

}
