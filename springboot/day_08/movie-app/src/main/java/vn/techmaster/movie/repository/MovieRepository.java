package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Movie;

// Movie : Tên Entity
// Integer: Kiểu dữ liệu của khóa chính
//@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
