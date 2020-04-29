package com.training.platform.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.training.platform.validators.FieldsValueMatch;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@FieldsValueMatch(field = "password", fieldMatch = "confirmPassword", message = "The password fields must match")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name is a required field")
    @Size(min = 2, message = "Name should have at least 2 characters")
    @Size(max = 100, message = "Name should have not over 5 characters")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Surname is a required field")
    @Size(min = 2, message = "Surname should have at least 2 characters")
    @Size(max = 100, message = "Surname should have not over 5 characters")
    private String surname;

    @Column(name = "email")
    @NotEmpty(message = "Email is a required field")
//    @Email(message = "Email is a email pattern")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password is a required field")
    private String password;

    @Transient
//    @NotEmpty(message = "Confirm Password is a required field")
    private String confirmPassword;

    @Column(name = "age")
//    @NotEmpty(message = "Age is a required field")
    private int age;

    @Column(name = "address")
    @NotEmpty(message = "Address is a required field")
    private String address;

    @Column(name = "city")
    @NotEmpty(message = "City is a required field")
    private String city;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "active")
    private int active;

    @Column(name = "api_token")
    private String apiToken;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "created_at")
    private Date createedAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Shop shop;

}
