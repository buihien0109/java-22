package vn.techmaster.movie.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.movie.model.request.UpsertGenreRequest;
import vn.techmaster.movie.service.GenreService;

@Slf4j
@RestController
@RequestMapping("api/admin/genres")
@RequiredArgsConstructor
public class GenreApi {
    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<?> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenreById(@PathVariable Integer id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }

    @PostMapping
    public ResponseEntity<?> createGenre(@RequestBody UpsertGenreRequest request) {
        return new ResponseEntity<>(genreService.saveGenre(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGenre(@PathVariable Integer id, @RequestBody UpsertGenreRequest request) {
        return ResponseEntity.ok(genreService.updateGenre(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable Integer id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
