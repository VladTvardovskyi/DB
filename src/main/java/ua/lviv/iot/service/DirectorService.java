package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Director;
import ua.lviv.iot.repository.DirectorRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    public Director getById(Integer id) {
        return directorRepository.findById(id).get();
    }

    @Transactional
    public void create(Director director) {
        directorRepository.save(director);
    }

    @Transactional
    public void update(Director director, Integer id) {
        if (directorRepository.findById(id).isPresent()) {
            Director oldDirector = directorRepository.findById(id).get();
            oldDirector.setFirstName(director.getFirstName());
            oldDirector.setLastName(director.getLastName());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if (directorRepository.findById(id).isPresent()) {
            directorRepository.deleteById(id);
        }
    }
}
