package org.karolinaprojects.store;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class Product {
    private String name;
    private String type;
    private int id;
    private Date date;

    public Product(){};

    public Product(String name, String type, int id, Date date) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                getName().equals(product.getName()) &&
                getType().equals(product.getType()) &&
                getDate().equals(product.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getId(), getDate());
    }
}
