package vn.techmaster.movie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.movie.entity.Genre;
import vn.techmaster.movie.service.GenreService;

import java.util.List;

@Controller
@RequestMapping("/admin/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public String getHomePage(Model model) {
        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("genreList", genreList);
        return "admin/genre/index";
    }
}
