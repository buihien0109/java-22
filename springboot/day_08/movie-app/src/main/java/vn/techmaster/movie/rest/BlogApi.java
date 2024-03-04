package vn.techmaster.movie.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.movie.entity.Blog;
import vn.techmaster.movie.model.request.UpsertBlogRequest;
import vn.techmaster.movie.service.BlogService;

@RestController
@RequestMapping("/api/admin/blogs")
@RequiredArgsConstructor
public class BlogApi {
    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<?> createBlog(@RequestBody UpsertBlogRequest request) {
        Blog blog = blogService.createBlog(request);
        return ResponseEntity.ok(blog); // status code 200
    }

    // Cập nhật review - PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBlog(@RequestBody UpsertBlogRequest request, @PathVariable Integer id) {
        Blog blog = blogService.updateBlog(id, request);
        return ResponseEntity.ok(blog); // status code 200
    }

    // Xóa review - DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build(); // status code 204
    }
}
