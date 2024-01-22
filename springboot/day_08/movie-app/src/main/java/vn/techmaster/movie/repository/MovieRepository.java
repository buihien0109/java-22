package vn.techmaster.movie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Movie;
import vn.techmaster.movie.model.enums.MovieType;

import java.util.List;
import java.util.Optional;

// Movie : Tên Entity
// Integer: Kiểu dữ liệu của khóa chính
//@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // Tìm kiếm movie theo title
    List<Movie> findByTitle(String title);

    // Lấy giới hạn số lượng bản ghi
    List<Movie> findFirstByTitle(String title);

    List<Movie> findTop5ByTitle(String title);

    // Tìm kiếm movie theo title chứa từ khóa keyword
    List<Movie> findByTitleContaining(String keyword);

    // Tìm kiếm movie theo title chứa từ khóa keyword không phân biệt hoa thường
    List<Movie> findByTitleContainingIgnoreCase(String keyword);

    // Tìm kiếm movie theo type và status
    List<Movie> findByTypeAndStatus(MovieType type, Boolean status);

    // Tìm kiếm movie theo type và status và sắp xếp theo view giảm dần
    List<Movie> findByTypeAndStatusOrderByViewDesc(MovieType type, Boolean status);

    // Tìm kiếm movie theo type và status và sắp xếp 1 trường bất kỳ
    List<Movie> findByTypeAndStatus(MovieType type, Boolean status, Sort sort);

    // Tìm kiếm movie theo type và status và phân trang
    Page<Movie> findByTypeAndStatus(MovieType type, Boolean status, Pageable pageable);

    // Tìm kiếm movie theo rating trong khoảng [min, max]
    List<Movie> findByRatingBetween(Double min, Double max);

    // Tìm kiếm các bộ phim có releaseYear > năm chỉ định
    List<Movie> findByReleaseYearGreaterThan(Integer year);

    // Tìm kiếm các bộ phim có releaseYear nằm trong các năm chỉ định
    List<Movie> findByReleaseYearIn(List<Integer> years);

    // Đếm số lượng movie theo status
    long countByStatus(Boolean status);

    // Kiểm tra xem có movie nào có title chứa keyword không
    boolean existsByTitleContaining(String keyword);

    List<Movie> findByTypeAndStatusAndRatingGreaterThanEqualAndIdNotOrderByRatingDescViewDescPublishedAtDesc(MovieType type, Boolean status, Double rating, Integer id);

    Page<Movie> findByStatus(Boolean status, Pageable pageable);

    Optional<Movie> findByIdAndSlugAndStatus(Integer id, String slug, Boolean status);
}
