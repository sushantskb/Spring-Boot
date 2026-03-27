package com.rahulgudu2003.hospitalManagement.Project.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String specilization;

    @Column(nullable = false, unique = true, length = 100)
    private String licenseNumber;

    @ManyToMany(mappedBy = "doctors") // inversed side of the relationship, mapped by the 'doctors' field in
                                      // Department entity
    private Set<Department> departments;
}
