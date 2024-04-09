package com.poly.datt.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Profile")
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name",nullable = false)
    private String FirstName;

    @Column(name = "last_name",nullable = false)
    private String LastName;

    @Column(name ="date_of_birth",nullable = false)
    private String DateofBirth;

    @Column(name="gender",nullable = false)
    private String Gender;

    @Column(name="adress",nullable = false)
    private String Adress;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Profile(String firstName, String lastName, String dateofBirth, String gender, String adress, User user) {
        FirstName = firstName;
        LastName = lastName;
        DateofBirth = dateofBirth;
        Gender = gender;
        Adress = adress;
        this.user = user;
    }
}

