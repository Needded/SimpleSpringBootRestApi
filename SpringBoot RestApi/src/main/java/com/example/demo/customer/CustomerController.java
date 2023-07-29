package com.example.demo.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller + @ResponseBody. Controller that leads with RESTful.
@RequestMapping("customers")//Mapping HTTP path.
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired//Search for customerController bean
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
	
	@GetMapping//Get 
	public List<Customer> getCustomers() {
		return customerService.get();
	}
	record Add(String name,int age) {}
	
	@PostMapping
	public void addCustomer(@RequestBody Add add) {
		customerService.add(add);
	}
	
	@PutMapping(path="/{id}")
	public void updateCustomer(@PathVariable("id")int id,@RequestBody Add update) {
		customerService.update(id,update);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteCustomer(@PathVariable("id")int id) {
		customerService.delete(id);
	}


}
