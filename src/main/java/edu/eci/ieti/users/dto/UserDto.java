package edu.eci.ieti.users.dto;

import java.time.LocalDate;

public class UserDto {
    String id;
    String name;
    String email;
    String lastName;
    String createdAt;

    String password;

    public UserDto(){
        this.id = String.valueOf((int)(Math.random()*9));
        this.createdAt = LocalDate.now().toString();
    }

    public UserDto(String name, String email, String lastName){
        this();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDto(String id,String name, String email, String lastName, String createdAt){
        this(name, email, lastName);
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getPassword() {
        return password;
    }

}
