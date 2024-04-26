package pt.app.servicio;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.app.modelo.Booking;
import pt.app.repositorio.BookingRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServicio implements IBookingServicio{

    private BookingRepositorio bookingrepositorio;

    @Autowired
    public BookingServicio(BookingRepositorio bookingrepositorio) {
        this.bookingrepositorio = bookingrepositorio;
    }

    @Override
    public List<Booking> Read() {
        return bookingrepositorio.findAll();
    }

    @Override
    public Optional<Booking> Search(Integer bookingid) {
        return bookingrepositorio.findById(bookingid);
    }

    @Override
    public Booking Save(Booking booking) {
        return bookingrepositorio.save(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookingrepositorio.delete(booking);
    }
}
