package nl.novi.techiteasy_spring.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "WallBrackets")
public class WallBracket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String size;
    Boolean adjustable;
    String name;
    Double price;
    @ManyToMany
    List<Television> televisions;

    public Long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
