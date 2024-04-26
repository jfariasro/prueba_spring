package pt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.app.modelo.Movie;
import pt.app.servicio.IMovieServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sistema")
@CrossOrigin(value = "htpp://localhost:3000")
public class MovieController {
    private static final Logger logger =
            LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private IMovieServicio movieServicio;

    @GetMapping("/movie")
    public List<Movie> ReadMovie(){
        var movie = movieServicio.Read();
        movie.forEach((movie1 -> logger.info(movie1.toString())));
        return movie;
    }

    @GetMapping("/movie/{movieid}")
    public Optional<Movie> SearchMovie(@PathVariable Integer movieid){
        var movie = movieServicio.Search(movieid);
        logger.info(movie.toString());
        return movie;
    }

    @PostMapping("/movie")
    public Movie SaveMovie(@RequestBody Movie movie){
        return movieServicio.Save(movie);
    }

    @DeleteMapping("/movie")
    public ResponseEntity<String> deleteMovie(@RequestBody Movie movie) {
        try {
            movieServicio.delete(movie);
            return ResponseEntity.ok("Movie deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting: " + e.getMessage());
        }
    }
}
