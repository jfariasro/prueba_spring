package pt.app.servicio;

import pt.app.modelo.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieServicio {
    public List<Movie> Read();

    public Optional<Movie> Search(Integer movieid);

    public Movie Save(Movie movie);

    public void delete(Movie movie);
}
