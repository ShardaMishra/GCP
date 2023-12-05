package com.gcp.entity;

import jakarta.persistence.*;
import lombok.*;



import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID serviceId;

    private String empName;

//    @OneToOne
//    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
//    private GoogleCloud googleCloud;

    @ManyToMany//(cascade = CascadeType.ALL,optional = true)
    @JoinTable(name="Emp_SR", joinColumns = @JoinColumn(name="empId"),
    inverseJoinColumns = @JoinColumn(name="serviceId"))
    private List<GoogleCloud> googleCloud;
}
