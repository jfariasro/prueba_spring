package pt.app.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.app.modelo.Customer;
import pt.app.repositorio.CustomerRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicio implements ICustomerServicio {

    private CustomerRepositorio customerrepositorio;

    @Autowired
    public CustomerServicio(CustomerRepositorio customerrepositorio) {
        this.customerrepositorio = customerrepositorio;
    }

    @Override
    public List<Customer> Read() {
        return customerrepositorio.findAll();
    }

    @Override
    public Optional<Customer> Search(Integer customerid){
        return customerrepositorio.findById(customerid);
    }

    @Override
    public Customer Save(Customer customer) {
        return customerrepositorio.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerrepositorio.delete(customer);
    }
}
