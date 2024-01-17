package vn.techmaster.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WevController {
    // Trang chủ
    @GetMapping("/")
    public String getHome() {
        return "web/index";
    }

    // Danh sách phim chiếu rạp
    @GetMapping("/phim-chieu-rap")
    public String getPhimChieuRap() {
        return "web/phim-chieu-rap";
    }

    // Danh sách phim lẻ
    @GetMapping("/phim-le")
    public String getPhimLe() {
        return "web/phim-le";
    }

    // Danh sách phim bộ
    @GetMapping("/phim-bo")
    public String getPhimBo() {
        return "web/phim-bo";
    }

    // Chi tiết phim
    @GetMapping("/phim/{id}/{slug}")
    public String getChiTietPhim(@PathVariable Integer id, @PathVariable String slug) {
        return "web/chi-tiet-phim";
    }
}
