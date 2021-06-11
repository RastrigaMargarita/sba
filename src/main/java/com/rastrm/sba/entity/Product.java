package com.rastrm.sba.entity;


import javax.persistence.*;

@Entity
@Table(name = "productlist")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;


    public Product(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "" + id + "{" + title + ", " + price + "}";
    }

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
}
