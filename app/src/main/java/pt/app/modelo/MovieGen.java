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
public class MovieGen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer moviegenid;

    @Column(name = "name", nullable = false, length = 50)
    String name;
}
