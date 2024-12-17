package com.FluffyTerror.AutoServiceProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Defects")
public class Defects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "defect_id")
    private Long defectId;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cars car;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "resolved", nullable = false)
    private Boolean resolved = false;

    // Геттеры и сеттеры
    public Long getDefectId() {
        return defectId;
    }

    public void setDefectId(Long defectId) {
        this.defectId = defectId;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
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