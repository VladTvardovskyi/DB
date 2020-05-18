package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/film_db")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/countries/{id}")
    public Country getById(@PathVariable Integer id) {
        return countryService.getById(id);
    }

    @PostMapping("/countries")
    public void create(@RequestBody Country country) {
        countryService.create(country);
    }

    @PutMapping("/countries/{id}")
    public void update(@PathVariable Integer id, @RequestBody Country country) {
        countryService.update(country, id);
    }

    @DeleteMapping("/countries/{id}")
    public void delete(@PathVariable Integer id) {
        countryService.delete(id);
    }
}
