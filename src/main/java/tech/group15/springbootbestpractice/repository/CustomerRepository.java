package tech.group15.springbootbestpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.group15.springbootbestpractice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {}
