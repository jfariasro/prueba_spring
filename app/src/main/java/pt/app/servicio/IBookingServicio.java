package pt.app.servicio;

import pt.app.modelo.Booking;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface IBookingServicio {
    public List<Booking> Read();

    public Optional<Booking> Search(Integer bookingid);

    public Booking Save(Booking booking);

    public void delete(Booking booking);
}
