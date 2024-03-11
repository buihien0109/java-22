package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Video;

public interface VideoRepository extends JpaRepository<Video, String> {
}