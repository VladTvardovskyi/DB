package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Star;
import ua.lviv.iot.repository.StarRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StarService {
    @Autowired
    StarRepository starRepository;

    public List<Star> getAll() {
        return starRepository.findAll();
    }

    public Star getById(Integer id) {
        return starRepository.findById(id).get();
    }

    @Transactional
    public void create(Star star) {
        starRepository.save(star);
    }

    @Transactional
    public void update(Star star, Integer id) {
        if (starRepository.findById(id).isPresent()) {
            Star oldStar = starRepository.findById(id).get();
            oldStar.setFirstName(star.getFirstName());
            oldStar.setLastName(star.getLastName());
            oldStar.setAge(star.getAge());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if (starRepository.findById(id).isPresent()) {
            starRepository.deleteById(id);
        }
    }
}
