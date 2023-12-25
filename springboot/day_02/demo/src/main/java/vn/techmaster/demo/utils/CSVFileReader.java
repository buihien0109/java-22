package vn.techmaster.demo.utils;

import org.springframework.stereotype.Component;
import vn.techmaster.demo.model.Book;

import java.util.List;

@Component
public class CSVFileReader implements IFileReader {
    @Override
    public List<Book> readFile(String filePath) {
        return null;
    }
}
