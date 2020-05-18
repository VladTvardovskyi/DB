package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.BoxOffice;
import ua.lviv.iot.model.BoxOfficePK;
import ua.lviv.iot.service.BoxOfficeService;

import java.util.List;

@RestController
@RequestMapping("/film_db")
public class BoxOfficeController {
    @Autowired
    BoxOfficeService boxOfficeService;

    @GetMapping("/boxOffices")
    public List<BoxOffice> getAll() {
        return boxOfficeService.getAll();
    }

    @GetMapping("/boxOffices/{id}")
    public BoxOffice getById(@PathVariable BoxOfficePK id) {
        return boxOfficeService.getById(id);
    }

    @PostMapping("/boxOffices")
    public void create(@RequestBody BoxOffice boxOffice) {
        boxOfficeService.create(boxOffice);
    }

    @PutMapping("/boxOffices/{id}")
    public void update(@PathVariable BoxOfficePK id, @RequestBody BoxOffice boxOffice) {
        boxOfficeService.update(boxOffice, id);
    }

    @DeleteMapping("/boxOffice/{id}")
    public void delete(@PathVariable BoxOfficePK id) {
        boxOfficeService.delete(id);
    }
}
