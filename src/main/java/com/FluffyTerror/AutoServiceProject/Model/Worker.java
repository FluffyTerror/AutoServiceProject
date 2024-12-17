package com.FluffyTerror.AutoServiceProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    // Геттеры и сеттеры
    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
