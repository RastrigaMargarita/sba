package com.rastrm.sba.repository;

import com.rastrm.sba.entity.Customer;
import com.rastrm.sba.entity.EntityItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class CustomerRepository implements RepositoryInt {

    private final EntityManager entityManager;

    public CustomerRepository(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public void newItem(EntityItem customer) {

        entityManager.getTransaction().begin();
        ((Customer) customer).setId(0);
        entityManager.persist(customer);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public String getAllList() {
        return entityManager.createNativeQuery("select * from customers", Customer.class).getResultList().toString();
    }

    @Override
    public void delByID(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findByID(id));
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    @Override
    public Customer findByID(int id) {
        return entityManager.find(Customer.class, id);
    }

}
