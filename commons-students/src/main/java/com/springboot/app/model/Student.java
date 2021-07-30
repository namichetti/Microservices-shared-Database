package com.springboot.app.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="last_name")
    private String lastName;
    private String email;
    @CreationTimestamp
    @Column(name="create_at")
    private LocalDate createAt;
    
    @Lob
    @JsonIgnore
    private byte[] photo;

}
