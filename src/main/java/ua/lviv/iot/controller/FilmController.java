package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Film;
import ua.lviv.iot.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/film_db")
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public List<Film> getAll() {
        return filmService.getAll();
    }

    @GetMapping("/films/{id}")
    public Film getById(@PathVariable Integer id) {
        return filmService.getById(id);
    }

    @PostMapping("/films")
    public void create(@RequestBody Film film) {
        filmService.create(film);
    }

    @PutMapping("/films/{id}")
    public void update(@PathVariable Integer id, @RequestBody Film film) {
        filmService.update(film, id);
    }

    @DeleteMapping("/films/{id}")
    public void delete(@PathVariable Integer id) {
        filmService.delete(id);
    }
}
