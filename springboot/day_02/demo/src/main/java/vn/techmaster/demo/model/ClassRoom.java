package vn.techmaster.demo.model;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class ClassRoom {
//    @Autowired
//    private Teacher teacher;
//
//    @Autowired
//    private Student student;

    private final Teacher teacher;
    private final Student student;

    public ClassRoom(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
        System.out.println("ClassRoom constructor");
    }
}
