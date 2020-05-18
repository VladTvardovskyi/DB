package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.BoxOffice;
import ua.lviv.iot.model.BoxOfficePK;

public interface BoxOfficeRepository extends JpaRepository<BoxOffice, BoxOfficePK> {
}
