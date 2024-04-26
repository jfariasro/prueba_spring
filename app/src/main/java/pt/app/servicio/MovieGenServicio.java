package pt.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.app.modelo.MovieGen;
import pt.app.repositorio.MovieGenRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class MovieGenServicio implements IMovieGenServicio{

    private MovieGenRepositorio moviegenrepositorio;

    @Autowired
    public MovieGenServicio(MovieGenRepositorio moviegenrepositorio) {
        this.moviegenrepositorio = moviegenrepositorio;
    }

    @Override
    public List<MovieGen> Read() {
        return moviegenrepositorio.findAll();
    }

    @Override
    public Optional<MovieGen> Search(Integer moviegenid) {
        return moviegenrepositorio.findById(moviegenid);
    }

    @Override
    public MovieGen Save(MovieGen moviegen) {
        return moviegenrepositorio.save(moviegen);
    }

    @Override
    public void delete(MovieGen moviegen) {
        moviegenrepositorio.delete(moviegen);
    }
}
