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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customerid;

    @Column(name = "document_number", nullable = false, unique = true, length = 20)
    String documentNumber;

    @Column(name = "name", nullable = false, length = 30)
    String name;

    @Column(name = "lastname", nullable = false, length = 30)
    String lastname;

    @Column(name = "age", nullable = false)
    Short age;

    @Column(name = "phonenumber", length = 20)
    String phonenumber;

    @Column(name = "email", length = 100)
    String email;
}
