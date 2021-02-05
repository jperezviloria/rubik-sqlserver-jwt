package com.rubikstore.rubik.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_users")
    private int idUser;

    private String username;

    private String password;

    @Column(name = "email")
    private String emailUser;

    @Column(name = "age")
    private int ageUser;
}
