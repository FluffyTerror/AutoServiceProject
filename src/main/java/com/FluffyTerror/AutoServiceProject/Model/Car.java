package com.FluffyTerror.AutoServiceProject.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private CarOwner owner;

    // Регистрационный номер
    @Column(unique = true)
    private String administrativeNumber;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Defect> defects;

    @Column(name = "manufacture_year", nullable = false)
    private int manufactureYear;

    @Column(name = "manufacturer", length = 30, nullable = false)
    private String manufacturer;

    @Column(name = "brand", length = 30, nullable = false)
    private String brand;


    // Геттеры и сеттеры
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public CarOwner getOwner() {
        return owner;
    }

    public void setOwner(CarOwner owner) {
        this.owner = owner;
    }

    public List<Defect> getDefects() {
        return defects;
    }

    public void setDefects(List<Defect> defects) {
        this.defects = defects;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAdministrativeNumber() {
        return administrativeNumber;
    }

    public void setAdministrativeNumber(String administrativeNumber) {
        this.administrativeNumber = administrativeNumber;
    }


}

