package org.example.demo.thymeleaf.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    int id;
    String name;
    String email;
    int age;
    int score;
}
