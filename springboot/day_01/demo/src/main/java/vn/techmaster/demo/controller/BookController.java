package vn.techmaster.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.demo.model.Book;

import java.util.ArrayList;
import java.util.List;

/*
 * @Controller : Trả về View Template, Ngoài ra cũng có thể trả về JSON, XML
 * @RestController : Trả về JSON, XML
 * HTTP Method: GET, POST, PUT, DELETE
 * */
@RestController
@RequestMapping("/books") //URL: http://localhost:8080/books, URL: http://localhost:8080/books/getAllBooks,
public class BookController {
    private final List<Book> books;

    public BookController() {
        books = new ArrayList<>();
        books.add(new Book("1", "Gone with the wind", "Cuong", 1945));
        books.add(new Book("2", "Chi Dau", "Nam Cao", 1943));
    }

    @GetMapping(path = {"", "/getAllBooks"})
    // @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks() {
        return books;
    }

//    @GetMapping("/getAllBooks")
//    public List<Book> getAllBooks() {
//        return books;
//    }

    // http://localhost:8080/books/1
    // http://localhost:8080/books/2
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        System.out.println("id: " + id);
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}