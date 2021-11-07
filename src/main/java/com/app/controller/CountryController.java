package com.app.controller;

import java.util.List;

import javax.swing.event.ListDataListener;

import com.app.iservice.ICountry;
import com.app.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private ICountry service;

    @RequestMapping("/save")
    public String saveCountry(@RequestBody Country country) {
        String res = service.saveCountry(country);
        return res;

    }

    @GetMapping(value = "/getcountry")
    public Country getMethodName(@RequestParam Integer id) {
        return service.getCountryById(id);

    }

    @GetMapping(value = "/getall")
    public List<Country> getAll() {
        return service.getAllCountries();
    }

    @PutMapping(value = "/update")
    public String updateCountry(@RequestBody Country country) {
        String res = service.updateCountry(country);
        return res;
    }

    @DeleteMapping(value = "/delete")
    public String deleteCountry(@RequestParam Integer id) {
        String res = service.deleteCountry(id);
        return res;
    }
}
