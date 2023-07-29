package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//Mark as a Connector to the DataBase through JPA repository( spring Data Jpa)
public interface CustomerRepository extends JpaRepository<Customer,Integer >{

}
