package com.rastrm.sba;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class Product {

    private String title;
    private double cost;
    private int id;


    public Product(String title, double cost, int id) {
        this.title = title;
        this.cost = cost;
        this.id = id;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "" + id + "{" + title + ", " + cost + "}";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }
}
