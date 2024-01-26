package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}