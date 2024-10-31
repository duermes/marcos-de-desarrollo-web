package com.mddw.readers.THE_READERS.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class RegisterRequest {
    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "El apellido es requerido")
    private String lastName;

    @NotBlank(message = "El nombre de usuario es requerido")
    private String username;

    @Email(message = "Debe ser un email válido")
    @NotBlank(message = "El email es requerido")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    private String password;

    private Integer number;

    @NotBlank(message = "El género es requerido")
    private String gender;

    public RegisterRequest() {
    }

    public RegisterRequest(String name, String lastName, String username, String email, String password, Integer number, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.number = number;
        this.gender = gender;
    }

    public @NotBlank(message = "El nombre es requerido") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "El nombre es requerido") String name) {
        this.name = name;
    }

    public @NotBlank(message = "El apellido es requerido") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "El apellido es requerido") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "El nombre de usuario es requerido") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "El nombre de usuario es requerido") String username) {
        this.username = username;
    }

    public @Email(message = "Debe ser un email válido") @NotBlank(message = "El email es requerido") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Debe ser un email válido") @NotBlank(message = "El email es requerido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "La contraseña es requerida") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "La contraseña es requerida") String password) {
        this.password = password;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public @NotBlank(message = "El género es requerido") String getGender() {
        return gender;
    }

    public void setGender(@NotBlank(message = "El género es requerido") String gender) {
        this.gender = gender;
    }
}