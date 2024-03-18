package vn.techmaster.movie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.techmaster.movie.repository.BlogRepository;
import vn.techmaster.movie.repository.MovieRepository;
import vn.techmaster.movie.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardService {
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final MovieRepository movieRepository;


}
