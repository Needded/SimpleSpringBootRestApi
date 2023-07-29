package com.example.demo.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.CustomerController.Add;

@Service//Service Bean
public class CustomerService {

	
	private CustomerRepository customerRepository;
	
	@Autowired//Search for customerService bean
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	public List<Customer> get() {
		return customerRepository.findAll();
	}

	
	public void add(Add add) {
		Customer addCustomer=new Customer();
		addCustomer.setName(add.name());
		addCustomer.setAge(add.age());
		customerRepository.save(addCustomer);
		
	}


	public void update(int id, Add update) {
		
		verify(id);
		
		Customer customer=new Customer();
		Optional <Customer>idExist=customerRepository.findById(id);
	
		
		customer=idExist.get();
		customer.setName(update.name());
		customer.setAge(update.age());
		
		
		customerRepository.save(customer);
		
	}


	public void delete(int id) {
		
		verify(id);
		customerRepository.deleteById(id);
		
	}
	
	public void verify (int id) {
		
		boolean exist = customerRepository.existsById(id);
		
		if(exist) {
			return;
		}else {throw new IllegalStateException("Student with id"+ id +"does not exists.");
		      }
	}
	
   

}
