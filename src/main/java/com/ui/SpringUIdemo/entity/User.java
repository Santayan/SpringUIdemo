package com.ui.SpringUIdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @Email
    @NotEmpty
    @Column(unique=true)
    private String email;
    @NotEmpty
    private String name;
    @Size(min=4)
    private String password;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Task> task ;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLES", joinColumns = {
            @JoinColumn(name="USER_EMAIL",referencedColumnName = "email")

    }, inverseJoinColumns = {@JoinColumn(name="ROLE_NAME",referencedColumnName = "name")})
    private List<Role> roles;


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getTask() {
        return task;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public User(){}
}