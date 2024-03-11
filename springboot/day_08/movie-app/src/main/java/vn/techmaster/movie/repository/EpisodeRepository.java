package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Episode;

import java.util.List;
import java.util.Optional;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    List<Episode> findByMovie_IdOrderByDisplayOrderAsc(Integer movieId);

    List<Episode> findByMovie_IdAndStatusOrderByDisplayOrderAsc(Integer movieId, Boolean status);

    Optional<Episode> findByMovie_IdAndDisplayOrderAndStatus(Integer movieId, int i, boolean episodeStatus);
}