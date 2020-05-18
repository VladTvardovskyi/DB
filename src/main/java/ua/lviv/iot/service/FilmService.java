package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Film;
import ua.lviv.iot.repository.FilmRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    public Film getById(Integer id) {
        return filmRepository.findById(id).get();
    }

    @Transactional
    public void create(Film film) {
        filmRepository.save(film);
    }

    @Transactional
    public void update(Film film, Integer id) {
        if (filmRepository.findById(id).isPresent()) {
            Film oldFilm = filmRepository.findById(id).get();
            oldFilm.setTitle(film.getTitle());
            oldFilm.setRunningTime(film.getRunningTime());
            oldFilm.setReleaseDate(film.getReleaseDate());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if (filmRepository.findById(id).isPresent()) {
            filmRepository.deleteById(id);
        }
    }
}
