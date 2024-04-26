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
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer movieid;

    @Column(name = "name", nullable = false, length = 100)
    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moviegenid", nullable = false)
    MovieGen moviegen;

    @Column(name = "allowedage", nullable = false)
    Short allowedAge;
}
