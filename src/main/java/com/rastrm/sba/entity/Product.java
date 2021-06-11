package com.rastrm.sba.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productlist")
public class Product extends EntityItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @ManyToMany
    @JoinTable(
            name = "purchases",
            joinColumns = @JoinColumn(name = "product"),
            inverseJoinColumns = @JoinColumn(name = "customer")
    )
    private List<Product> customersList;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double cost) {
        this.price = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public List<Product> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Product> customersList) {
        this.customersList = customersList;
    }
}
