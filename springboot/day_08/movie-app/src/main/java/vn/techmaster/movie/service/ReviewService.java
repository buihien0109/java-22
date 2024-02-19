package vn.techmaster.movie.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techmaster.movie.entity.Movie;
import vn.techmaster.movie.entity.Review;
import vn.techmaster.movie.entity.User;
import vn.techmaster.movie.exception.BadRequestException;
import vn.techmaster.movie.exception.ResourceNotFoundException;
import vn.techmaster.movie.model.request.UpsertReviewRequest;
import vn.techmaster.movie.repository.MovieRepository;
import vn.techmaster.movie.repository.ReviewRepository;
import vn.techmaster.movie.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    // Lấy danh sách review theo id phim
    public List<Review> getReviewsByMovie(Integer id) {
        return reviewRepository.findByMovie_IdOrderByCreatedAtDesc(id);
    }

    // Tạo review
    public Review createReview(UpsertReviewRequest request) {
        // TODO: Fix userId = 1. Sau này user là user đang login
        Integer userId = 1;

        // Tìm kiếm user theo id
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user có id: " + userId));

        // Kiểm tra movieId có tồn tại không?
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy movie có id: " + request.getMovieId()));

        // Tạo review
        Review review = Review.builder()
                .comment(request.getComment())
                .rating(request.getRating())
                .user(user)
                .movie(movie)
                .build();

        return reviewRepository.save(review);
    }

    // Cập nhật review
    public Review updateReview(Integer id, UpsertReviewRequest request) {
        // TODO: Fix userId = 1. Sau này user là user đang login
        Integer userId = 1;

        // Tìm kiếm user theo id
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user có id: " + userId));

        // Kiểm tra movieId có tồn tại không?
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy movie có id: " + request.getMovieId()));

        // Kiểm tra review có tồn tại không?
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy review có id: " + id));

        // Kiểm tra xem review có phải của user đang login không? Nếu không báo lỗi
        if (!review.getUser().getId().equals(user.getId())) {
            throw new BadRequestException("Bạn không có quyền cập nhật review này");
        }

        // Kiểm tra xem review có phải của movie không? Nếu không báo lỗi
        if (!review.getMovie().getId().equals(movie.getId())) {
            throw new BadRequestException("Review này không phải của movie này");
        }

        // Cập nhật review
        review.setComment(request.getComment());
        review.setRating(request.getRating());

        return reviewRepository.save(review);
    }

    // Xóa review
    public void deleteReview(Integer id) {
        // TODO: Fix userId = 1. Sau này user là user đang login
        Integer userId = 1;

        // Tìm kiếm user theo id
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user có id: " + userId));

        // Kiểm tra review có tồn tại không?
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy review có id: " + id));

        // Kiểm tra xem review có phải của user đang login không? Nếu không báo lỗi
        if (!review.getUser().getId().equals(user.getId())) {
            throw new BadRequestException("Bạn không có quyền xóa review này");
        }

        reviewRepository.delete(review);
    }
}
