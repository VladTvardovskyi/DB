package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.repository.CountryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country getById(Integer id) {
        return countryRepository.findById(id).get();
    }

    @Transactional
    public void create(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void update(Country country, Integer id) {
        if (countryRepository.findById(id).isPresent()) {
            Country oldCountry = countryRepository.findById(id).get();
            oldCountry.setName(country.getName());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if (countryRepository.findById(id).isPresent()) {
            countryRepository.deleteById(id);
        }
    }
}
