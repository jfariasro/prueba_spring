package pt.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.app.modelo.BillBoard;

public interface BillBoardRepositorio extends JpaRepository<BillBoard, Integer> {
}
