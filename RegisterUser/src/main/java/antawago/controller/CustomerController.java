    package controller;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import model.Customer;
        import repository.CustomerRepository;

        @CrossOrigin(origins = "http://localhost:4200")
        @RestController
        @RequestMapping("/api")
        public class CustomerController {

        @Autowired
        CustomerRepository repository;

        @GetMapping("/customers")
        public List<Customer> getAllCustomers() {
        System.out.println("Get all Customers...");

        List<Customer> customers = new ArrayList<>();
        repository.findAll().forEach(customers::add);

        return customers;
        }

        @PostMapping(value = "/customers/create")
        public Customer postCustomer(@RequestBody Customer customer) {

        Customer _customer = repository.save(new Customer(customer.getName(), customer.getCI(), customer.getPhone(),
        customer.getDirection()));
        return _customer;
        }

        @GetMapping(value = "customers/name/{name}")
        public List<Customer> findByName(@PathVariable String name) {

        List<Customer> customers = repository.findByName(name);
        return customers;
        }

        }
