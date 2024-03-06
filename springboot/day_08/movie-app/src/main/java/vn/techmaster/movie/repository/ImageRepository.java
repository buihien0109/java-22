package vn.techmaster.movie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, String> {
    List<Image> findByUser_IdOrderByCreatedAtDesc(Integer id);

    Page<Image> findByUser_IdOrderByCreatedAtDesc(Integer id, Pageable pageable);
}