package org.example.demo.thymeleaf.controller;

import org.example.demo.thymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/*
 * /students?rank=gioi : Lấy tất cả học sinh có rank = gioi
 * /students?rank=kha : Lấy tất cả học sinh có rank = kha
 * /students : Lấy tất cả
 * */
@Controller
public class WebController {
    private final List<Student> students = new ArrayList<>(List.of(
            new Student(1, "An", "an@gmail.com", 20, 8),
            new Student(2, "Sơn", "son@gmail.com", 16, 10),
            new Student(3, "Hang", "hang@gmail.com", 32, 6),
            new Student(4, "Nguyệt", "nguyet@gmail.com", 44, 5),
            new Student(5, "Minh", "minh@gmail.com", 26, 9),
            new Student(6, "Tuấn", "tuan@gmail.com", 28, 7)
    ));

    @GetMapping("/")
    public String getHome(Model model, @RequestParam(required = false) String rank) {
        // Trả về 1 đối tượng
        model.addAttribute("student", students.get(0));

        // Trả về 1 list đối tượng
        List<Student> studentList = new ArrayList<>();
        if (rank != null) {
            if (rank.equals("gioi")) {
                studentList = students.stream()
                        .filter(s -> s.getScore() > 8)
                        .toList();
            } else if (rank.equals("kha")) {
                studentList = students.stream()
                        .filter(s -> s.getScore() <= 8)
                        .toList();
            }
        } else {
            studentList = students;
        }
        model.addAttribute("students", studentList);
        return "index";
    }

    @GetMapping("/students/{id}")
    public String getStudentDetailPage(@PathVariable int id, Model model) {
        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("student", student);
        return "student-detail";
    }

    @GetMapping("/blog")
    public String getBlog() {
        return "admin/blog";
    }
}
