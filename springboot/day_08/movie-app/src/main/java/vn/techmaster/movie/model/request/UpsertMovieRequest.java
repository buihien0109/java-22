package vn.techmaster.movie.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techmaster.movie.model.enums.MovieType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpsertMovieRequest {
    String title;
    String description;
    Boolean status;
    MovieType type;
    Integer releaseYear;
    String poster;
    List<Integer> directorIds;
    List<Integer> actorIds;
    List<Integer> genreIds;
}