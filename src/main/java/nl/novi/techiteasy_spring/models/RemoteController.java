package nl.novi.techiteasy_spring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "RemoteControllers")
public class RemoteController {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;
    String compatibleWith;
    String batteryType;
    String name;
    String brand;
    Double price;
    Integer originalStock;
    @OneToOne(mappedBy = "remoteController")
    Television television;

    public long getId() {
        return id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }
}
