package pt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.app.modelo.Customer;
import pt.app.servicio.ICustomerServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sistema")
@CrossOrigin(value = "htpp://localhost:3000")
public class CustomerController {
    private static final Logger logger =
            LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ICustomerServicio customerservicio;

    @GetMapping("/customer")
    public List<Customer> ReadCustomer(){
        var customer = customerservicio.Read();
        customer.forEach((customers -> logger.info(customers.toString())));
        return customer;
    }

    @GetMapping("/customer/{customerid}")
    public Optional<Customer> SearchCustomer(@PathVariable Integer customerid){
        var customer = customerservicio.Search(customerid);
        logger.info(customer.toString());
        return customer;
    }

    @PostMapping("/customer")
    public Customer SaveCustomer(@RequestBody Customer customer){
        return customerservicio.Save(customer);
    }

    @DeleteMapping("/customer")
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) {
        try {
            customerservicio.delete(customer);
            return ResponseEntity.ok("Customer deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting: " + e.getMessage());
        }
    }

}
