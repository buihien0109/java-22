package vn.techmaster.movie.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techmaster.movie.model.enums.UserRole;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @Column(nullable = false, unique = true)
    String email;

    String password;
    String avatar;

    @Enumerated(EnumType.STRING)
    UserRole role;

    Date createdAt;
    Date updatedAt;
}
