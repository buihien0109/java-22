package vn.techmaster.demo.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Teacher {
    private int id;
    private String name;

    public Teacher() {
        System.out.println("Teacher constructor");
    }
}
