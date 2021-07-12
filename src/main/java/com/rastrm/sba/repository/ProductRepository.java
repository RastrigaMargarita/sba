package com.rastrm.sba.repository;

import com.rastrm.sba.entity.EntityItem;
import com.rastrm.sba.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class ProductRepository implements RepositoryInt {

    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public void newItem(EntityItem product) {

        entityManager.getTransaction().begin();
        ((Product) product).setId(0);
        entityManager.persist(product);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public String getAllList() {
        return entityManager.createNativeQuery("select * from productlist", Product.class).getResultList().toString();
    }

    @Override
    public void delByID(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findByID(id));
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    @Override
    public Product findByID(int id) {
        return entityManager.find(Product.class, id);
    }


}
