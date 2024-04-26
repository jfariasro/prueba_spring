package pt.app.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer seatid;

    @Column(name = "number", nullable = false)
    Short number;

    @Column(name = "rownumber", nullable = false)
    Short rownumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomid", nullable = false)
    private Room room;
}
