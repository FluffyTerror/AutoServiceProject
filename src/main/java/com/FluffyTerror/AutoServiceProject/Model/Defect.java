package com.FluffyTerror.AutoServiceProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Defects")
public class Defect {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Геттеры и сеттеры

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "resolved", nullable = false)
    private Boolean resolved = false;

    // Геттеры и сеттеры
    // Исправленные геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
