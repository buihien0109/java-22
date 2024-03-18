package vn.techmaster.movie.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Blog;

import java.util.Date;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByUser_Id(Integer id, Sort sort);

    long countByCreatedAtBetween(Date start, Date end);
}