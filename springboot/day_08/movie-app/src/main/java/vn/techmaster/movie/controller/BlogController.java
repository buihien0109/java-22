package vn.techmaster.movie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/blogs")
@RequiredArgsConstructor
public class BlogController {

    @GetMapping
    public String viewHomePage() {
        return "admin/blog/index";
    }

    @GetMapping("/own-blogs")
    public String viewOwnBlogPage() {
        return "admin/blog/own-blog";
    }

    @GetMapping("/create")
    public String viewCreatePage() {
        return "admin/blog/create";
    }

    @GetMapping("/{id}/detail")
    public String viewDetailPage(@PathVariable Integer id) {
        return "admin/blog/detail";
    }
}
