package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
