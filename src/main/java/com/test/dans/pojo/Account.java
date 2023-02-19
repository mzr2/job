package com.test.dans.pojo;

//import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="account", schema="public")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
}
