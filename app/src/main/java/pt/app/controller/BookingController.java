package pt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.app.modelo.Booking;
import pt.app.servicio.IBookingServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sistema")
@CrossOrigin(value = "htpp://localhost:3000")
public class BookingController {
    private static final Logger logger =
            LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private IBookingServicio bookingServicio;

    @GetMapping("/booking")
    public List<Booking> ReadBooking(){
        var booking = bookingServicio.Read();
        booking.forEach((booking1 -> logger.info(booking1.toString())));
        return booking;
    }

    @GetMapping("/booking/{bookingid}")
    public Optional<Booking> SearchBooking(@PathVariable Integer bookingid){
        var booking = bookingServicio.Search(bookingid);
        logger.info(booking.toString());
        return booking;
    }

    @PostMapping("/booking")
    public Booking SaveBooking(@RequestBody Booking booking){
        return bookingServicio.Save(booking);
    }

    @DeleteMapping("/booking")
    public ResponseEntity<String> deleteBooking(@RequestBody Booking booking) {
        try {
            bookingServicio.delete(booking);
            return ResponseEntity.ok("Booking deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting: " + e.getMessage());
        }
    }
}
