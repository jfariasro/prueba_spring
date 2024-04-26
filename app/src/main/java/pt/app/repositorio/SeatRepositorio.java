package pt.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.app.modelo.Seat;

public interface SeatRepositorio extends JpaRepository<Seat, Integer> {
}
