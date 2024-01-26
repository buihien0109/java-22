package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}