package tech.group15.springbootbestpractice.mapper;

import tech.group15.springbootbestpractice.dto.CustomerDTO;
import tech.group15.springbootbestpractice.model.Customer;

public class CustomerMapper {
  public static CustomerDTO convertEntityToDTO(Customer customer) {
    CustomerDTO customerDTO = new CustomerDTO();

    customerDTO.setFullName(customer.getFirstName() + " " + customer.getLastName());
    customerDTO.setAge(customer.getAge());
    return customerDTO;
  }
}
