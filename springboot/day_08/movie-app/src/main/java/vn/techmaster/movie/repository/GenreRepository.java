package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}