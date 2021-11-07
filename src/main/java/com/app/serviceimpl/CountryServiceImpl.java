package com.app.serviceimpl;

import java.util.List;

import com.app.iservice.ICountry;
import com.app.model.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountry {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String saveCountry(Country country) {
        String SQL = "INSERT INTO Country(name,capital) values(?,?)";
        jdbcTemplate.update(SQL, country.getName(), country.getCapital());
        return "Country Saved";
    }

    @Override
    public String updateCountry(Country country) {
        String SQL = "UPDATE Country SET name=?,capital=? WHERE id=?";
        jdbcTemplate.update(SQL, country.getName(), country.getCapital(), country.getId());
        return "Country Updated";
    }

    @Override
    public String deleteCountry(int id) {
        String SQL = "Delete from country whre id=?";
        int res = jdbcTemplate.update(SQL, id);
        if (res > 0) {
            return "Country Deleted";
        } else {
            return "Country Not Deleted";
        }
    }

    @Override
    public Country getCountryById(int id) {
        String SQL = "SELECT * FROM Country WHERE id=?";
        return jdbcTemplate.queryForObject(SQL, (rs, rowNum) -> {
            Country c = new Country();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setCapital(rs.getString("capital"));
            return c;
        }, id);

    }

    @Override
    public List<Country> getAllCountries() {
        String SQL = "SELECT * FROM Country";
        return jdbcTemplate.query(SQL, (rs, rowNum) -> {
            Country c = new Country();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setCapital(rs.getString("capital"));
            return c;
        });

    }

}
