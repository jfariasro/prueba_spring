package pt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.app.modelo.MovieGen;
import pt.app.servicio.IMovieGenServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sistema")
@CrossOrigin(value = "htpp://localhost:3000")
public class MovieGenController {
    private static final Logger logger =
            LoggerFactory.getLogger(MovieGenController.class);

    @Autowired
    private IMovieGenServicio moviegenservicio;

    @GetMapping("/moviegen")
    public List<MovieGen> ReadMovieGen(){
        var moviegen = moviegenservicio.Read();
        moviegen.forEach((movieGen -> logger.info(movieGen.toString())));
        return moviegen;
    }

    @GetMapping("/moviegen/{moviegenid}")
    public Optional<MovieGen> SearchMovieGen(@PathVariable Integer moviegenid){
        var moviegen = moviegenservicio.Search(moviegenid);
        logger.info(moviegen.toString());
        return moviegen;
    }

    @PostMapping("/moviegen")
    public MovieGen SaveMovieGen(@RequestBody MovieGen moviegen){
        return moviegenservicio.Save(moviegen);
    }

    @DeleteMapping("/moviegen")
    public ResponseEntity<String> deleteMovieGen(@RequestBody MovieGen moviegen) {
        try {
            moviegenservicio.delete(moviegen);
            return ResponseEntity.ok("Movie Gen deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting: " + e.getMessage());
        }
    }
}
