package pt.app.servicio;

import org.springframework.stereotype.Service;
import pt.app.modelo.Seat;
import pt.app.repositorio.SeatRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServicio implements ISeatServicio{

    private SeatRepositorio seatrepositorio;

    public SeatServicio(SeatRepositorio seatrepositorio) {
        this.seatrepositorio = seatrepositorio;
    }

    @Override
    public List<Seat> Read() {
        return seatrepositorio.findAll();
    }

    @Override
    public Optional<Seat> Search(Integer seatid) {
        return seatrepositorio.findById(seatid);
    }

    @Override
    public Seat Save(Seat seat) {
        return seatrepositorio.save(seat);
    }

    @Override
    public void delete(Seat seat) {
        seatrepositorio.delete(seat);
    }
}
