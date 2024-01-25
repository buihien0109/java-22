package vn.techmaster.movie;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.techmaster.movie.entity.Blog;
import vn.techmaster.movie.entity.Movie;
import vn.techmaster.movie.model.enums.MovieType;
import vn.techmaster.movie.repository.MovieRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
public class InitDataTests {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void save_users() {
    }

    @Test
    void save_blogs() {
        for (int i = 0; i < 30; i++) {
            // Random 1 user có role ADMIN

            // Tạo blog với user này
            Blog blog = Blog.builder()
                    // .user()
                    .build();
        }
    }

    @Test
    void save_movies() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        Random random = new Random();

        Date start = new Calendar.Builder().setDate(2023, 8, 1).build().getTime();
        Date end = new Date();

        for (int i = 0; i < 100; i++) {
            String title = faker.book().title();
            boolean status = faker.bool().bool();
            Date createdAt = randomDateBetweenTwoDates(start, end);
            Date publishedAt = null;
            if (status) {
                publishedAt = createdAt;
            }

            Movie movie = Movie.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().paragraph())
                    .poster(generateLinkImage(title))
                    .releaseYear(faker.number().numberBetween(2021, 2024))
                    .view(faker.number().numberBetween(1000, 10000))
                    .rating(faker.number().randomDouble(1, 6, 10))
                    .type(MovieType.values()[random.nextInt(MovieType.values().length)])
                    .status(status)
                    .createdAt(createdAt)
                    .updatedAt(createdAt)
                    .publishedAt(publishedAt)
                    .build();

            movieRepository.save(movie);
        }
    }

    // write method to random date between 2 date
    private Date randomDateBetweenTwoDates(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);
        return new Date(randomMillisSinceEpoch);
    }

    // generate link author avatar follow struct : https://placehold.co/200x200?text=[...]
    public static String generateLinkImage(String str) {
        return "https://placehold.co/200x200?text=" + str.substring(0, 1).toUpperCase();
    }
}
