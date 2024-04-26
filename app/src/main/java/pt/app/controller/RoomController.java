package pt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.app.modelo.Room;
import pt.app.servicio.IRoomServicio;
import pt.app.servicio.RoomServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sistema")
@CrossOrigin(value = "htpp://localhost:3000")
public class RoomController {
    private static final Logger logger =
            LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private IRoomServicio roomservicio;

    @GetMapping("/room")
    public List<Room> ReadRoom(){
        var room = roomservicio.Read();
        room.forEach((room1 -> logger.info(room1.toString())));
        return room;
    }

    @GetMapping("/room/{roomid}")
    public Optional<Room> SearchRoom(@PathVariable Integer roomid){
        var room = roomservicio.Search(roomid);
        logger.info(room.toString());
        return room;
    }

    @PostMapping("/room")
    public Room SaveRoom(@RequestBody Room room){
        return roomservicio.Save(room);
    }

    @DeleteMapping("/room")
    public ResponseEntity<String> deleteRoom(@RequestBody Room room) {
        try {
            roomservicio.delete(room);
            return ResponseEntity.ok("Room deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting: " + e.getMessage());
        }
    }
}
