package kerellpnz.springbootthymeleaf.dao;


import kerellpnz.springbootthymeleaf.model.Customer;

import java.util.List;

public interface CustomerDAO {

	List<Customer> findAll();
	Customer findById(int theId);
	void save(Customer theCustomer);
	void deleteById(int theId);
}
