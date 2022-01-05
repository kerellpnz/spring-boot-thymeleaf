package kerellpnz.springbootthymeleaf.service;

import kerellpnz.springbootthymeleaf.dao.CustomerDAO;
import kerellpnz.springbootthymeleaf.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(@Qualifier("customerDAOHibernateImpl") CustomerDAO theCustomerDAO) {
		customerDAO = theCustomerDAO;
	}
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}

}






