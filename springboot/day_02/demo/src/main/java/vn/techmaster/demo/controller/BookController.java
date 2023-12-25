package vn.techmaster.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.demo.model.Book;

import java.util.ArrayList;
import java.util.List;

/*
 * @Controller : Trả về View Template, Ngoài ra cũng có thể trả về JSON, XML
 * @RestController : Trả về JSON, XML
 * HTTP Method: GET, POST, PUT, DELETE
 * @RestController = @Controller + @ResponseBody
 * Class ResponseEntity<T>: Đại diện cho một HTTP response, bao gồm: status code, headers, và body.
 * */
//@RestController

@Controller
@RequestMapping("/books") //URL: http://localhost:8080/books, URL: http://localhost:8080/books/getAllBooks,
public class BookController {
    private final List<Book> books;

    public BookController() {
        books = new ArrayList<>();
        books.add(new Book("1", "Gone with the wind", "Cuong", 1945));
        books.add(new Book("2", "Chi Dau", "Nam Cao", 1943));
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

//    @GetMapping(path = {"", "/getAllBooks"})
//    // @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED) // 201
//    public List<Book> getBooks() {
//        return books;
//    }

    @GetMapping(path = {"", "/getAllBooks"})
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(books, HttpStatus.CREATED);
    }

//    @GetMapping("/getAllBooks")
//    public List<Book> getAllBooks() {
//        return books;
//    }

    // http://localhost:8080/books/1
    // http://localhost:8080/books/2
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        System.out.println("id: " + id);
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return ResponseEntity.ok(book);
            }
        }
        return null;
    }
}