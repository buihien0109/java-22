package vn.techmaster.demo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demo.model.Book;
import vn.techmaster.demo.utils.IFileReader;

@Configuration
public class InitDB implements CommandLineRunner { // interface này sẽ được chạy khi Spring Boot khởi động xong
    @Autowired
    private IFileReader fileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Đọc dữ liệu từ file JSON");

        BookDB.bookList = fileReader.readFile("book.json");
        System.out.println("Số lượng sách trong database: " + BookDB.bookList.size());

        for(Book book : BookDB.bookList) {
            System.out.println(book);
        }
    }
}
