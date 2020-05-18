package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
