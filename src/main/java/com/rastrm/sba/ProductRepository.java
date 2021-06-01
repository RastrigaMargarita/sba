package com.rastrm.sba;

import com.rastrm.sba.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> productList = new ArrayList<Product>();

    public void newProduct(Product product, String title) {
        product.setTitle(title);
        productList.add(product);
    }

    public String getAllList() {
        return productList.toString();
    }

    public void delByID(int ID) {
        productList.remove(ID);
    }

}
