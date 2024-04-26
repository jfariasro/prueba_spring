package pt.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.app.modelo.Movie;

public interface MovieRepositorio extends JpaRepository<Movie, Integer> {
}
