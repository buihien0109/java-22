package vn.techmaster.movie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.movie.entity.Movie;
import vn.techmaster.movie.entity.Review;
import vn.techmaster.movie.model.enums.MovieType;
import vn.techmaster.movie.service.MovieService;
import vn.techmaster.movie.service.ReviewService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final MovieService movieService;
    private final ReviewService reviewService;

    // Trang chủ
    @GetMapping("/")
    public String getHomePage(Model model) {
        Page<Movie> pageDataPhimHot = movieService.getHotMovies(true, 1, 8);
        Page<Movie> pageDataPhimLe = movieService.getMoviesByType(MovieType.PHIM_LE, true, 1, 6);
        Page<Movie> pageDataPhimBo = movieService.getMoviesByType(MovieType.PHIM_BO, true, 1, 6);
        Page<Movie> pageDataPhimChieuRap = movieService.getMoviesByType(MovieType.PHIM_CHIEU_RAP, true, 1, 6);

        model.addAttribute("phimHotList", pageDataPhimHot.getContent());
        model.addAttribute("phimLeList", pageDataPhimLe.getContent());
        model.addAttribute("phimBoList", pageDataPhimBo.getContent());
        model.addAttribute("phimChieuRapList", pageDataPhimChieuRap.getContent());
        return "web/index";
    }

    // Danh sách phim chiếu rạp
    // /phim-chieu-rap?page=1&size=12 -> page = 1, size = 12
    // /phim-chieu-rap -> page = 1, size = 12
    @GetMapping("/phim-chieu-rap")
    public String getPhimChieuRap(Model model,
                                  @RequestParam(required = false, defaultValue = "1") Integer page,
                                  @RequestParam(required = false, defaultValue = "12") Integer size) {
        Page<Movie> pageData = movieService.getMoviesByType(MovieType.PHIM_CHIEU_RAP, true, page, size);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-chieu-rap";
    }

    // Danh sách phim lẻ
    @GetMapping("/phim-le")
    public String getPhimLe(Model model,
                            @RequestParam(required = false, defaultValue = "1") Integer page,
                            @RequestParam(required = false, defaultValue = "12") Integer size) {
        Page<Movie> pageData = movieService.getMoviesByType(MovieType.PHIM_LE, true, page, size);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-le";
    }

    // Danh sách phim bộ
    @GetMapping("/phim-bo")
    public String getPhimBo(Model model,
                            @RequestParam(required = false, defaultValue = "1") Integer page,
                            @RequestParam(required = false, defaultValue = "12") Integer size) {
        Page<Movie> pageData = movieService.getMoviesByType(MovieType.PHIM_BO, true, page, size);
        model.addAttribute("pageData", pageData);
        model.addAttribute("currentPage", page);
        return "web/phim-bo";
    }

    // Chi tiết phim
    @GetMapping("/phim/{id}/{slug}")
    public String getPhimDetailPage(Model model, @PathVariable Integer id, @PathVariable String slug) {
        Movie movie = movieService.getMovie(id, slug, true);
        List<Movie> relatedMovieList = movieService.getRelatedMovies(id, movie.getType(), true, 6);
        List<Review> reviewList = reviewService.getReviewsByMovie(id);

        model.addAttribute("movie", movie);
        model.addAttribute("relatedMovieList", relatedMovieList);
        model.addAttribute("reviewList", reviewList);
        return "web/chi-tiet-phim";
    }
}
