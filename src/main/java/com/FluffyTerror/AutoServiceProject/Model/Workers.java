package com.FluffyTerror.AutoServiceProject.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity

@Table(name = "Workers")
public class Workers {
    @Id
    private Long workerId;

    @Column(nullable = false)
    private String fullName;

}
