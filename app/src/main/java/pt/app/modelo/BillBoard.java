package pt.app.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BillBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer billboardid;

    @Column(name = "date", nullable = false)
    LocalDate date;

    @Column(name = "starttime", nullable = false)
    LocalTime starttime;

    @Column(name = "endtime", nullable = false)
    LocalTime endtime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movieid", nullable = false)
    Movie movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomid", nullable = false)
    Room room;
}
