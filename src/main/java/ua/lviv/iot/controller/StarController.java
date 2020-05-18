package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Star;
import ua.lviv.iot.service.StarService;

import java.util.List;

@RestController
@RequestMapping("/film_db")
public class StarController {
    @Autowired
    StarService starService;

    @GetMapping("/stars")
    public List<Star> getAll() {
        return starService.getAll();
    }

    @GetMapping("/stars/{id}")
    public Star getById(@PathVariable Integer id) {
        return starService.getById(id);
    }

    @PostMapping("/stars")
    public void create(@RequestBody Star star) {
        starService.create(star);
    }

    @PutMapping("/stars/{id}")
    public void update(@PathVariable Integer id, @RequestBody Star star) {
        starService.update(star, id);
    }

    @DeleteMapping("/stars/{id}")
    public void delete(@PathVariable Integer id) {
        starService.delete(id);
    }
}
