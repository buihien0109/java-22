package vn.techmaster.demo.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import vn.techmaster.demo.model.Book;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelFileReader implements IFileReader {
    @Override
    public List<Book> readFile(String filePath) {
        List<Book> books = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // skip header row
                Book book = new Book();
                book.setId(row.getCell(0).getStringCellValue());
                book.setTitle(row.getCell(1).getStringCellValue());
                book.setAuthor(row.getCell(2).getStringCellValue());
                book.setYear((int) row.getCell(3).getNumericCellValue());
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
}
