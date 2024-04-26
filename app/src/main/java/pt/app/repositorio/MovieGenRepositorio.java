package pt.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.app.modelo.MovieGen;

public interface MovieGenRepositorio extends JpaRepository<MovieGen, Integer> {
}
