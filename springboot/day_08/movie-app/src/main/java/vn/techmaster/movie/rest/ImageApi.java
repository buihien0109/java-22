package vn.techmaster.movie.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.movie.service.ImageService;

@RestController
@RequestMapping("api/admin/images")
@RequiredArgsConstructor
public class ImageApi {
    private final ImageService imageService;

    // 1. Lấy danh sách ảnh của user
    @GetMapping
    public ResponseEntity<?> getAllImagesByCurrentUser(@RequestParam(required = false, defaultValue = "1") int page,
                                                       @RequestParam(required = false, defaultValue = "12") int limit) {
        return ResponseEntity.ok(imageService.getAllImagesByCurrentUser(page, limit));
    }

    // 2. Upload ảnh mới
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(imageService.uploadImage(file), HttpStatus.CREATED);
    }

    // 3. Xóa ảnh
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable String id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
