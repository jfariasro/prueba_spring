package pt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.app.modelo.Seat;
import pt.app.servicio.ISeatServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sistema")
@CrossOrigin(value = "htpp://localhost:3000")
public class SeatController {

    private static final Logger logger =
            LoggerFactory.getLogger(SeatController.class);

    @Autowired
    private ISeatServicio seatServicio;

    @GetMapping("/seat")
    public List<Seat> ReadSeat(){
        var seat = seatServicio.Read();
        seat.forEach((seat1 -> logger.info(seat1.toString())));
        return seat;
    }

    @GetMapping("/seat/{seatid}")
    public Optional<Seat> SearchSeat(@PathVariable Integer seatid){
        var seat = seatServicio.Search(seatid);
        logger.info(seat.toString());
        return seat;
    }

    @PostMapping("/seat")
    public Seat SaveSeat(@RequestBody Seat seat){
        return seatServicio.Save(seat);
    }

    @DeleteMapping("/seat")
    public ResponseEntity<String> deleteSeat(@RequestBody Seat seat) {
        try {
            seatServicio.delete(seat);
            return ResponseEntity.ok("Seat deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting: " + e.getMessage());
        }
    }
}
