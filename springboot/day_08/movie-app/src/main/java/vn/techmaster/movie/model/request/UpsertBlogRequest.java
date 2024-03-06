package vn.techmaster.movie.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpsertBlogRequest {
    String title;
    String content;
    String description;
    Boolean status;
    String thumbnail;
}
