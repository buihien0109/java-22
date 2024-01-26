package vn.techmaster.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.movie.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}