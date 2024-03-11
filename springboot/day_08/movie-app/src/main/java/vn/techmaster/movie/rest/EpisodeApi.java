package vn.techmaster.movie.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movie.service.EpisodeService;

@RestController
@RequestMapping("/api/admin/episodes")
@RequiredArgsConstructor
public class EpisodeApi {
    private final EpisodeService episodeService;

    @PostMapping("/{id}/upload-video")
    public ResponseEntity<?> uploadVideo(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
        episodeService.uploadVideo(id, file);
        return ResponseEntity.ok().build(); // status code 200
    }
}
