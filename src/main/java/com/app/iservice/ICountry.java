package com.app.iservice;

import java.util.List;

import com.app.model.Country;

public interface ICountry {

    String saveCountry(Country country);

    String updateCountry(Country country);

    String deleteCountry(int id);

    Country getCountryById(int id);

    List<Country> getAllCountries();
}
