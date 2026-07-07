package com.library.library_management_api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//marking class book as a database entity using @Entity annotation. This tells the JPA provider that this class should be mapped to a database table.
@Entity
public class Member {

    //primary key
    @Id
    //tells JPA that a fields value should be automatically generated. The strategy attribute specifies the primary key generation strategy. GenerationType.IDENTITY indicates that the database should generate the primary key value, typically using an auto-increment column.
    //generation type define how id should be generated. GenerationType.IDENTITY means that the database will automatically generate a unique identifier for each new entity instance, typically using an auto-incrementing column.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;


    public Member() {
    }


    public Member(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
