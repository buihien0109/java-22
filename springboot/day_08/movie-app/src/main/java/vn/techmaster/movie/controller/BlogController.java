package vn.techmaster.movie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.movie.service.BlogService;
import vn.techmaster.movie.service.ImageService;

@Controller
@RequestMapping("admin/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final ImageService imageService;

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "admin/blog/index";
    }

    @GetMapping("/own-blogs")
    public String viewOwnBlogPage(Model model) {
        model.addAttribute("blogs", blogService.getAllOwnBlogs());
        return "admin/blog/own-blog";
    }

    @GetMapping("/create")
    public String viewCreatePage() {
        return "admin/blog/create";
    }

    @GetMapping("/{id}/detail")
    public String viewDetailPage(@PathVariable Integer id, Model model) {
        model.addAttribute("images", imageService.getAllImagesByCurrentUser());
        return "admin/blog/detail";
    }
}
