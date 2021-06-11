package com.rastrm.sba;

import com.rastrm.sba.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class ProductRepository {

    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void newProduct(Product product) {

        entityManager.getTransaction().begin();
        product.setId(0);
        entityManager.persist(product);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public String getAllList() {
        return entityManager.createNativeQuery("select * from productlist", Product.class).getResultList().toString();
    }

    public void delByID(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findByID(id));
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    public Product findByID(int id) {
        return entityManager.find(Product.class, id);
    }

}
