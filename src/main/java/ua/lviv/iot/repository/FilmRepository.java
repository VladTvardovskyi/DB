package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
