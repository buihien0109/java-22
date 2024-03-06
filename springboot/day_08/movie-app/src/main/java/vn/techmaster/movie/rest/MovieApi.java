package vn.techmaster.movie.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.movie.entity.Movie;
import vn.techmaster.movie.model.request.UpsertMovieRequest;
import vn.techmaster.movie.service.MovieService;

@RestController
@RequestMapping("/api/admin/movies")
@RequiredArgsConstructor
public class MovieApi {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody UpsertMovieRequest request) {
        Movie movie = movieService.createMovie(request);
        return ResponseEntity.ok(movie); // status code 200
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@RequestBody UpsertMovieRequest request, @PathVariable Integer id) {
        Movie movie = movieService.updateMovie(id, request);
        return ResponseEntity.ok(movie); // status code 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build(); // status code 204
    }
}
