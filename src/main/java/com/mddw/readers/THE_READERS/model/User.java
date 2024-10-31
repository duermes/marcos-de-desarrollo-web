package com.mddw.readers.THE_READERS.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "El nombre es requerido")
    private String name;

    @NotEmpty(message = "El apellido es requerido")
    private String lastName;

    @NotEmpty(message = "El nombre de usuario es requerido")
    @Column(unique = true)
    private String username;

    @Email(message = "Debe ser un email válido")
    @NotEmpty(message = "El email es requerido")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "La contraseña es requerida")
    private String password;

    @Positive(message = "El número debe ser positivo")
    private Integer number;

    @NotEmpty(message = "El género es requerido")
    private String gender;

    public User() {}

    public User(Integer id, String name, String lastName, String username, String email, String password, Integer number, String gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.number = number;
        this.gender = gender;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return this.username.equals("admin");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}