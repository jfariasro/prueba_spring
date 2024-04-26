package pt.app.servicio;

import pt.app.modelo.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerServicio {
    public List<Customer> Read();

    public Optional<Customer> Search(Integer customerid);

    public Customer Save(Customer customer);

    public void delete(Customer customer);
}
