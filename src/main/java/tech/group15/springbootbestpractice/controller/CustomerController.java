package tech.group15.springbootbestpractice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.group15.springbootbestpractice.dto.CustomerDTO;
import tech.group15.springbootbestpractice.model.Customer;
import tech.group15.springbootbestpractice.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
  @Autowired CustomerService customerService;

  @PostMapping("/add")
  public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
    Customer savedCustomer = customerService.createCustomer(customer);
    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
  }

  @GetMapping("/get")
  public ResponseEntity<List<CustomerDTO>> fetchAllCustomers() {
    List<CustomerDTO> customerDTOList = customerService.fetchAllCustomers();
    return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") int id) {
    CustomerDTO customerDTO = customerService.findById(id);
    return new ResponseEntity<>(customerDTO, HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
    CustomerDTO customerDTO = customerService.updateById(customer);
    return new ResponseEntity<>(customerDTO, HttpStatus.OK);
  }
}
