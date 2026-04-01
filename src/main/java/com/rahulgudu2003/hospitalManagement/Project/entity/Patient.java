package com.rahulgudu2003.hospitalManagement.Project.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rahulgudu2003.hospitalManagement.Project.entity.type.BloodGroupType;

@Entity
@ToString
@Getter
@Setter
@Table(name = "patient", uniqueConstraints = {
                // @UniqueConstraint(name = "unique_patient_email", columnNames = { "email" }),
                // // not makes sense since only one column is there
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = { "name", "birthDate" }) // makes
                                                                                                                 // more
                                                                                                                 // sense
                                                                                                                 // for
                                                                                                                 // unique
                                                                                                                 // constraints
}, indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "birthDate")
})
// @Table(name = "patient_tbl", uniqueConstraints = {
// // @UniqueConstraint(name = "unique_patient_email", columnNames = { "email"
// }),
// // // not makes sense since only one column is there
// @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {
// "name", "birthDate" }) // makes more
// // sense for
// // unique
// // constraints
// }, indexes = {
// @Index(name = "idx_patient_birth_date", columnList = "birthDate")
// }) // just for understanding, we can also use @Table annotation to define
// unique constraints and indexes at the table level instead of column level
public class Patient {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // @Column(name = "patient_name", nullable = false, length = 40) // just for
        // understanding we can also use @Column annotation to define column name,
        // nullable and length constraints at the column level instead of table level
        @Column(nullable = false, length = 40)
        private String name;
        private LocalDate birthDate;

        @Column(unique = true, nullable = false)
        private String email;
        @ToString.Exclude
        private String gender;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        @Column(updatable = true)
        private LocalDateTime updatedTime;

        @Enumerated(EnumType.STRING)
        private BloodGroupType bloodGroup;

        @OneToOne(cascade = { CascadeType.ALL }, orphanRemoval = true) // owning side of the relationship, cascade all
                                                                       // operations and remove the
        // insurance if the patient is deleted
        @JoinColumn(name = "patient_insurance_id") // owning side of the relationship, defines the foreign key column in
        // the patient table
        private Insurance insurance;

        @OneToMany(mappedBy = "patient", cascade = { CascadeType.REMOVE, CascadeType.PERSIST
        }, orphanRemoval = true) // inversed side of the relationship, mapped by the 'appointment' field in
        // Appointment entity
        @ToString.Exclude
        private List<Appointment> appointments = new ArrayList<>();
}
