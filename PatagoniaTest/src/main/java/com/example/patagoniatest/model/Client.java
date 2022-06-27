package com.example.patagoniatest.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private Integer income;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
    private ClientType clientType;

    public Client(Long id, String fullName, Integer income, ClientType clientType) {
        this.id = id;
        this.fullName = fullName;
        this.income = income;
        this.clientType = clientType;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getIncome() {
        return income;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
