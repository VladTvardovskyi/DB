package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Genre;
import ua.lviv.iot.repository.GenreRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre getById(Integer id) {
        return genreRepository.findById(id).get();
    }

    @Transactional
    public void create(Genre genre) {
        genreRepository.save(genre);
    }

    @Transactional
    public void update(Genre genre, Integer id) {
        if (genreRepository.findById(id).isPresent()) {
            Genre oldGenre = genreRepository.findById(id).get();
            oldGenre.setName(genre.getName());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if (genreRepository.findById(id).isPresent()) {
            genreRepository.deleteById(id);
        }
    }
}
