package com.example.SpringbootWEBAPI.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "user_id", columnDefinition = "uuid")
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String firstName;


    private String lastName;


    private String contact;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;




}
