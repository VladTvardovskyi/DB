package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.BoxOffice;
import ua.lviv.iot.model.BoxOfficePK;
import ua.lviv.iot.repository.BoxOfficeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoxOfficeService {
    @Autowired
    BoxOfficeRepository boxOfficeRepository;

    public List<BoxOffice> getAll() {
        return boxOfficeRepository.findAll();
    }

    public BoxOffice getById(BoxOfficePK id) {
        return boxOfficeRepository.findById(id).get();
    }

    @Transactional
    public void create(BoxOffice boxOffice) {
        boxOfficeRepository.save(boxOffice);
    }

    @Transactional
    public void update(BoxOffice boxOffice, BoxOfficePK id) {
        if (boxOfficeRepository.findById(id).isPresent()) {
            BoxOffice oldBoxOffice = boxOfficeRepository.findById(id).get();
            oldBoxOffice.setBoxOffice(boxOffice.getBoxOffice());
        }
    }

    @Transactional
    public void delete(BoxOfficePK id) {
        if (boxOfficeRepository.findById(id).isPresent()) {
            boxOfficeRepository.deleteById(id);
        }
    }
}
