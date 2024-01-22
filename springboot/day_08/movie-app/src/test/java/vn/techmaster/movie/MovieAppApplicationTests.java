package vn.techmaster.movie;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.techmaster.movie.entity.Movie;
import vn.techmaster.movie.model.enums.MovieType;
import vn.techmaster.movie.repository.MovieRepository;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class MovieAppApplicationTests {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void test_movie_repo() {
//        List<Movie> movies = movieRepository.findAll();
//        System.out.println(movies.size());

//        Movie movie = movieRepository.findById(1).orElse(null);
//        System.out.println(movie);

//        movie.setTitle("Avatar 2");
//        movieRepository.save(movie);

//        movieRepository.deleteById(1);
//
//        Movie movie = movieRepository.findById(2).orElse(null);
//        movieRepository.delete(movie);

//        List<Movie> movies = movieRepository.findAll(Sort.by("view").descending());
//        movies.forEach(movie -> System.out.println(movie.getView()));

//        Pageable pageable = PageRequest.of(0, 6, Sort.by("publishedAt").descending());
//        Page<Movie> pageData = movieRepository.findByTypeAndStatus(MovieType.PHIM_LE, true, pageable);
//        System.out.println(pageData.getContent());
//        System.out.println(pageData.getTotalPages());
//        System.out.println(pageData.getTotalElements());
//        pageData.getContent().forEach(System.out::println);
    }
}
