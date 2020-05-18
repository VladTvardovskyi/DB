package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Genre;
import ua.lviv.iot.service.GenreService;

import java.util.List;

@RestController
@RequestMapping("/film_db")
public class GenreController {
    @Autowired
    GenreService genreService;

    @GetMapping("/genres")
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/genres/{id}")
    public Genre getById(@PathVariable Integer id) {
        return genreService.getById(id);
    }

    @PostMapping("/genres")
    public void create(@RequestBody Genre genre) {
        genreService.create(genre);
    }

    @PutMapping("/genres/{id}")
    public void update(@PathVariable Integer id, @RequestBody Genre genre) {
        genreService.update(genre, id);
    }

    @DeleteMapping("/genres/{id}")
    public void delete(@PathVariable Integer id) {
        genreService.delete(id);
    }
}
