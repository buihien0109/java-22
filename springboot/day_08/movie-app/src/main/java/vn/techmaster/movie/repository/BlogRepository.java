package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}