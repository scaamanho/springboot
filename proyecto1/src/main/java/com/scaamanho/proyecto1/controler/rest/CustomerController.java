package com.scaamanho.proyecto1.controler.rest;

import com.scaamanho.proyecto1.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
public class CustomerController
{
	private static Map<String, Customer> repo = new HashMap<>();
	static {

		Customer customer = new Customer();
		customer.setId("1");
		customer.setName("A1");
		customer.setSurname("B1");
		customer.setAddress("C1");
		repo.put(customer.getId(),customer);
		customer = new Customer();
		customer.setId("2");
		customer.setName("A2");
		customer.setSurname("B2");
		customer.setAddress("C2");
		repo.put(customer.getId(),customer);

	}

	//GET default rest controller path /customers
	@RequestMapping(value="/customers/")
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<>(repo.values(), HttpStatus.OK);
	}

	@RequestMapping(value="/customers/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
		return new ResponseEntity<>(repo.get(id), HttpStatus.OK);
	}

  //POST
	@RequestMapping(value="/customers/",method = RequestMethod.POST)
	public ResponseEntity<Object> insertProduct(@RequestBody Customer customer)
	{
		repo.put(customer.getId(),customer);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}


	//PUT
	@RequestMapping(value="/customers/",method = RequestMethod.PUT)
	public ResponseEntity<Object> put(@RequestBody Customer customer) {
		repo.put(customer.getId(),customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	//DELETE
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		Customer customer = repo.remove(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}
