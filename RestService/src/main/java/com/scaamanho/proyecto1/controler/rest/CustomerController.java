package com.scaamanho.proyecto1.controler.rest;

import com.scaamanho.proyecto1.fakedb.FakeDb;
import com.scaamanho.proyecto1.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/customer")
public class CustomerController
{
	@Autowired
	FakeDb fakeDb;

	//GET default rest controller path /customers
	@RequestMapping(value="/customers")
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<>(fakeDb.list(), HttpStatus.OK);
	}

	@RequestMapping(value="/customer/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
		return new ResponseEntity<>(fakeDb.get(id), HttpStatus.OK);
	}

  //POST
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<Object> insertProduct(@RequestBody Customer customer)
	{
		fakeDb.insert(customer);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}


	//PUT
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> put(@RequestBody Customer customer) {
		fakeDb.update(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	//DELETE
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		Customer customer = fakeDb.get(id);
		fakeDb.delete(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}
