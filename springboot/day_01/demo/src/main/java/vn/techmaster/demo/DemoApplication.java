package vn.techmaster.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.techmaster.demo.model.Book;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// Ví dụ 1: Khởi tạo đối tượng Book
		Book book = new Book("1", "Java", "Oracle", 2020);
		System.out.println(book);

		// Ví dụ 2: Khởi tạo đối tượng Book bằng Builder
		Book book2 = Book.builder()
				.author("Oracle")
				.title("Java")
				.build();
		System.out.println(book2);

		// Ví dụ 3: Khởi tạo đối tượng Book bằng Builder
		Book book3 = Book.builder()
				.year(2022)
				.author("Oracle")
				.title("Java")
				.build();
		System.out.println(book3);
	}

}
