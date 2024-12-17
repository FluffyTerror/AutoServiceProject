package com.FluffyTerror.AutoServiceProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_id")
    private Long carId;

    @Column(name = "Owner_id", nullable = false)
    private Long ownerId;

    @Column(name = "Manufacture_year", nullable = false)
    private int manufactureYear;

    @Column(name = "Manufacturer", length = 30, nullable = false)
    private String manufacturer;

    @Column(name = "Brand", length = 30, nullable = false)
    private String brand;

    @Column(name = "Administrative_number", nullable = false)
    private String administrativeNumber;

    // Геттеры и сеттеры
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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