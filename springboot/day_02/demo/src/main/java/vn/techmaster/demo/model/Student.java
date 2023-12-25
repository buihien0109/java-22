package vn.techmaster.demo.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        System.out.println("Student constructor");
        this.id = id;
        this.name = name;
    }
}
