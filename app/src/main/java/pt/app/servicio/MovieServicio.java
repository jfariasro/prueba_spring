package pt.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.app.modelo.Movie;
import pt.app.repositorio.MovieRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServicio implements IMovieServicio {
    private MovieRepositorio movierepositorio;

    @Autowired
    public MovieServicio(MovieRepositorio movierepositorio) {
        this.movierepositorio = movierepositorio;
    }

    @Override
    public List<Movie> Read() {
        return movierepositorio.findAll();
    }

    @Override
    public Optional<Movie> Search(Integer movieid) {
        return movierepositorio.findById(movieid);
    }

    @Override
    public Movie Save(Movie movie) {
        return movierepositorio.save(movie);
    }

    @Override
    public void delete(Movie movie) {
        movierepositorio.delete(movie);
    }
}
