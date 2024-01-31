package tech.group15.springbootbestpractice.service;

import java.util.List;
import tech.group15.springbootbestpractice.dto.CustomerDTO;
import tech.group15.springbootbestpractice.exception.CustomerNotFoundException;
import tech.group15.springbootbestpractice.model.Customer;

public interface CustomerService {
  Customer createCustomer(Customer customer);

  List<CustomerDTO> fetchAllCustomers();

  CustomerDTO findById(int id) throws CustomerNotFoundException;

  CustomerDTO updateById(Customer customer);
}
