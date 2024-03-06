package vn.techmaster.movie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.movie.model.enums.MovieType;
import vn.techmaster.movie.repository.ActorRepository;
import vn.techmaster.movie.repository.DirectorRepository;
import vn.techmaster.movie.repository.GenreRepository;
import vn.techmaster.movie.service.ImageService;
import vn.techmaster.movie.service.MovieService;

@Controller
@RequestMapping("admin/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final ImageService imageService;
    private final DirectorRepository directorRepository;
    private final ActorRepository actorRepository;
    private final GenreRepository genreRepository;


    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "admin/movie/index";
    }

    @GetMapping("/create")
    public String viewCreatePage(Model model) {
        model.addAttribute("directors", directorRepository.findAll());
        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        model.addAttribute("movieTypes", MovieType.values());
        return "admin/movie/create";
    }

    @GetMapping("/{id}/detail")
    public String viewDetailPage(@PathVariable Integer id, Model model) {
        model.addAttribute("images", imageService.getAllImagesByCurrentUser());
        return "admin/movie/detail";
    }
}
