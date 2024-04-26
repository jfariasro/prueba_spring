package pt.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.app.modelo.Room;

public interface RoomRepositorio extends JpaRepository<Room, Integer> {
}
