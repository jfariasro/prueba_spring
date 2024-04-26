package pt.app.controller;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.app.modelo.BillBoard;
import pt.app.servicio.IBillBoardServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sistema")
@CrossOrigin(value = "htpp://localhost:3000")
public class BillBoardController {
    private static final Logger logger =
            LoggerFactory.getLogger(BillBoardController.class);

    @Autowired
    private IBillBoardServicio bbservicio;

    @GetMapping("/billboard")
    public List<BillBoard> ReadBB(){
        var bb = bbservicio.Read();
        bb.forEach((billBoard -> logger.info(billBoard.toString())));
        return bb;
    }

    @GetMapping("/billboard/{billboardid}")
    public Optional<BillBoard> SearchBB(@PathVariable Integer billboardid){
        var bb = bbservicio.Search(billboardid);
        logger.info(bb.toString());
        return bb;
    }

    @PostMapping("/billboard")
    public BillBoard SaveBB(@RequestBody BillBoard bb){
        return bbservicio.Save(bb);
    }

    @DeleteMapping("/billboard")
    public ResponseEntity<String> deleteBB(@RequestBody BillBoard bb) {
        try {
            bbservicio.delete(bb);
            return ResponseEntity.ok("Bill Board deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting: " + e.getMessage());
        }
    }
}
