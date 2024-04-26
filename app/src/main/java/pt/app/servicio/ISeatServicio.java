package pt.app.servicio;

import pt.app.modelo.Seat;

import java.util.List;
import java.util.Optional;

public interface ISeatServicio {
    public List<Seat> Read();

    public Optional<Seat> Search(Integer seatid);

    public Seat Save(Seat seat);

    public void delete(Seat seat);
}
