package com.ebp.in.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Customer;
import com.ebp.in.exception.DuplicateCustomerException;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.CustomerRepository;
import com.ebp.in.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	/*
	 * New customer can register,If already exists it throw duplicate customer exception
	 */

	@Override
	public Customer registerCustomer(Customer customer) throws DuplicateCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}
	
	/*
	 * We can view Customer profile by taking customer id,
	 * if customer id does not exits throws no such customer exception
	 */

	@Override
	public Customer viewCustomerProfile(int customerId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return searchCustomerByCustomerId((long) customerId);
	}
	
	/*
	 * We can modify customer profile by taking customer id and customer,
	 * If customer does not exits throws no such customer exception
	 */

	@Override
	public Customer editCustomerProfile(int customerId, Customer customer) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	/*
	 * We can Search customer by taking customer id,
	 * If customerId does not exits throws no such customer exception
	 */
	@Override
	public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return (Customer) customerRepository.findById(customerId)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	/*
	 * We can Search customer by taking email,
	 * If email does not exits throws no such customer exception
	 */
	@Override
	public Customer searchCustomerByEmail(String email) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.readByEmail(email)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	/*
	 * We can search Customer by taking aadhaar number,
	 * If aadhaar does not exits throws no such customer exception
	 */
	@Override
	public Customer searchCustomerByAdhaar(Long adharNumber) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.readByAdharNumber(adharNumber)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	/*
	 * We can search customer by giving the mobile number,
	 * If mobile number does not exits throws no such customer exception
	 */
	@Override
	public Customer searchCustomerByMobile(String mobile) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return customerRepository.readByMobileNumber(mobile)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	/* 
	 * We can search customer name by giving the first name,
	 * If first name does not exits throws no such customer exception
	 */
	@Override
	public List<Customer> searchCustomerByName(String firstName) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		try {
			List<Customer> byName = customerRepository.readByFirstName(firstName);
			return byName;
		} catch (Exception e) {
			throw new NoSuchCustomerException("Customer with name:" + firstName + "not present");
		}

	}

}
