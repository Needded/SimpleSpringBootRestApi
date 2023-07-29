package com.example.demo.customer;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name="Customers")//Identify this object as a table.
@Table
public class Customer {
	
    @Id//Identify the id variable as the Id on the table.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Integer id;
	
	 @Column
	private String name="Junior";
	 
	 @Column
	private Integer age=1;
	
	public Customer(Integer id, String name, Integer age) {
		//this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Customer(String name, Integer age) {
		this.name = name;
		this.age = age;
	
	}
	public Customer() {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
