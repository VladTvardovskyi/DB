package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Star;

public interface StarRepository extends JpaRepository<Star, Integer> {
}
