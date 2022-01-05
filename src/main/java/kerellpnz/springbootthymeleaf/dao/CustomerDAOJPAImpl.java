package kerellpnz.springbootthymeleaf.dao;

import kerellpnz.springbootthymeleaf.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAOJPAImpl implements CustomerDAO {

    private final EntityManager entityManager;

    @Autowired
    public CustomerDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        Query theQuery = entityManager.createQuery("SELECT e FROM Customer e");
        return theQuery.getResultList();
    }

    @Override
    public Customer findById(int theId) {
        return entityManager.find(Customer.class, theId);
    }

    @Override
    public void save(Customer theCustomer) {
        entityManager.merge(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery("DELETE FROM Customer WHERE id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();
    }
}
