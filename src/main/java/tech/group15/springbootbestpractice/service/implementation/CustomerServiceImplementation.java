package tech.group15.springbootbestpractice.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.group15.springbootbestpractice.dto.CustomerDTO;
import tech.group15.springbootbestpractice.exception.CustomerNotFoundException;
import tech.group15.springbootbestpractice.mapper.CustomerMapper;
import tech.group15.springbootbestpractice.model.Customer;
import tech.group15.springbootbestpractice.repository.CustomerRepository;
import tech.group15.springbootbestpractice.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService {
  @Autowired CustomerRepository customerRepository;

  @Autowired private ModelMapper modelMapper;

  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  public List<CustomerDTO> fetchAllCustomers() {
    List<Customer> customerList = customerRepository.findAll();
    List<CustomerDTO> customerDTOList = new ArrayList<>();

    for (Customer customer : customerList) {

      /* Custom Mapper */
      CustomerDTO customerDTO = CustomerMapper.convertEntityToDTO(customer);

      /* Model Mapper */
      /* For this, the name of the attributes in Model and DTO needs to be same */
      /* CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class); */
      customerDTOList.add(customerDTO);
    }

    return customerDTOList;
  }

  public CustomerDTO findById(int id) {
    Optional<Customer> optionalCustomer = customerRepository.findById(id);
    return optionalCustomer
        .map(CustomerMapper::convertEntityToDTO)
        .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
  }

  public CustomerDTO updateById(Customer customer) {
    Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
    optionalCustomer
        .map(CustomerMapper::convertEntityToDTO)
        .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
    customerRepository.save(customer);
    return CustomerMapper.convertEntityToDTO(customer);
  }
}
