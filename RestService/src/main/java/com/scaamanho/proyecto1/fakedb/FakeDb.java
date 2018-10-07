package com.scaamanho.proyecto1.fakedb;

import com.scaamanho.proyecto1.model.Customer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/*

*/

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FakeDb
{
	private  Map<String, Customer> repo = new HashMap<>();

	public FakeDb()
	{
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

	public Customer get(String id)
	{
		return repo.get(id);
	}

	public Customer insert(Customer customer)
	{
		return repo.put(customer.getId(),customer);
	}

	public Customer update(Customer customer)
	{
		return insert(customer);
	}

	public Customer delete(Customer customer)
	{
		return repo.remove(customer.getId());
	}

	public Collection<Customer> list()
	{
		return repo.values();
	}
}
