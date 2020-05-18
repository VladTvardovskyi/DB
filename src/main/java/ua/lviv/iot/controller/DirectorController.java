package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Director;
import ua.lviv.iot.service.DirectorService;

import java.util.List;

@RestController
@RequestMapping("/film_db")
public class DirectorController {
    @Autowired
    DirectorService directorService;

    @GetMapping("/directors")
    public List<Director> getAll() {
        return directorService.getAll();
    }

    @GetMapping("/directors/{id}")
    public Director getById(@PathVariable Integer id) {
        return directorService.getById(id);
    }

    @PostMapping("/directors")
    public void create(@RequestBody Director director) {
        directorService.create(director);
    }

    @PutMapping("/directors/{id}")
    public void update(@PathVariable Integer id, @RequestBody Director director) {
        directorService.update(director, id);
    }

    @DeleteMapping("/directors/{id}")
    public void delete(@PathVariable Integer id) {
        directorService.delete(id);
    }
}
