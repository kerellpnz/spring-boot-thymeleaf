package kerellpnz.springbootthymeleaf.dao;

import kerellpnz.springbootthymeleaf.model.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

	private final EntityManager entityManager;
		
	@Autowired
	public CustomerDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Customer> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer", Customer.class);
		return theQuery.getResultList();
	}

	@Override
	public Customer findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Customer.class, theId);
	}

	@Override
	public void save(Customer theCustomer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = 
				currentSession.createQuery(
						"delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

}







