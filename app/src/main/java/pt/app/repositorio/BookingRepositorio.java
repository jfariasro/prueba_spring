package pt.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pt.app.modelo.Booking;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepositorio extends JpaRepository<Booking, Integer> {
    //Reservas por género y rango de fechas
    @Query(value = "SELECT b FROM Booking b " +
            "JOIN b.billboard bb " +
            "JOIN bb.movie m " +
            "WHERE m.moviegen.name = :genre " +
            "AND bb.date BETWEEN :startDate AND :endDate")
    List<Booking> findByGenreAndDateRange(@Param("genre") String genre,
                                          @Param("startDate") LocalDate startDate,
                                          @Param("endDate") LocalDate endDate);
}
