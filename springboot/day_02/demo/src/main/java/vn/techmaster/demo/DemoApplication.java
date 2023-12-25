package vn.techmaster.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import vn.techmaster.demo.model.ClassRoom;
import vn.techmaster.demo.model.Student;
import vn.techmaster.demo.model.Teacher;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);

        Student student = context.getBean(Student.class);
        System.out.println(student);

        ClassRoom classRoom = context.getBean(ClassRoom.class);
        System.out.println(classRoom);
    }

    @Bean // Chỉ sử dụng trong class @Configuration để khai báo một Bean
    public Student student() {
        return new Student(1, "Huy");
    }

}
