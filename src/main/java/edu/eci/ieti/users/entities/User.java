package edu.eci.ieti.users.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.eci.ieti.users.dto.UserDto;
import edu.eci.ieti.users.enums.RoleEnum;
//Imports for MongoDB
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Document
public class User {
    @Id
    String id;
    String name;

    @Indexed( unique = true )
    String email;

    String lastName;
    String createdAt;

    private String passwordHash;
    private List<RoleEnum> roles;


    public User(){
        this.id = String.valueOf((int)(Math.random()*9));
        this.createdAt = LocalDate.now().toString();
        this.roles = new ArrayList<>();
    }

    public User(UserDto userDto){
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getLastName();
        this.createdAt = userDto.getCreatedAt();
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
    }

    public User(String name, String email, String lastName){
        this();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String id,String name, String email, String lastName, String createdAt){
        this(name, email, lastName);
        this.id = id;
        this.createdAt = createdAt;
    }

    public void toEntity(UserDto userDto) {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        //New
        System.out.println("---------------Paswoord------------"+ userDto.getPassword());
        if (userDto.getPassword() != null) {
            this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        }
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

}
