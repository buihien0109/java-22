package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
}