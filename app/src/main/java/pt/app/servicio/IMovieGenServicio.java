package pt.app.servicio;

import pt.app.modelo.MovieGen;

import java.util.List;
import java.util.Optional;

public interface IMovieGenServicio {
    public List<MovieGen> Read();

    public Optional<MovieGen> Search(Integer moviegenid);

    public MovieGen Save(MovieGen moviegen);

    public void delete(MovieGen moviegen);
}
