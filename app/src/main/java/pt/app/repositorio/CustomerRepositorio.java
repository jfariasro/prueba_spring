package pt.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.app.modelo.Customer;

public interface CustomerRepositorio extends JpaRepository<Customer, Integer> {
}
