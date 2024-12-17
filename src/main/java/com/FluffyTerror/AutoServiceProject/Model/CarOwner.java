package com.FluffyTerror.AutoServiceProject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Car_owner")
public class CarOwner {
    @Id
    @Column(name = "Owner_id")
    private Long id;

    @Column(name = "Full_name", nullable = false)
    private String fullName;

    @Column(name = "Adress", nullable = false)
    private String address;

    @Column(name = "Car_brand", nullable = false)
    private String carBrand;

    @Column(name = "Administrative_number", unique = true, nullable = false)
    private String administrativeNumber;

    @OneToMany(mappedBy = "CarOwner")
    private List<Cars> cars;
}