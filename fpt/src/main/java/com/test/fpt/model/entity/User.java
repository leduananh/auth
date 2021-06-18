package com.test.fpt.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_name"}),
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotNull
    @NotBlank(message = "khong duoc de trong")
    @Column(name = "user_name")
    String userName;

    @NotNull
    @NotBlank(message = "khong duoc de trong")
    String password;

    @Column(name = "age")
    Integer age;

    @Column(name = "full_name")
    String fullName;

    @Email
    @NotEmpty(message = "Email is required")
    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private Boolean enabled;

    public User(@NotNull @NotBlank(message = "khong duoc de trong") String userName, @NotNull @NotBlank(message = "khong duoc de trong") String password, Integer age, String fullName, @Email @NotEmpty(message = "Email is required") String email, @NotEmpty(message = "role require!") String role, Boolean enabled) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
    }

    public User(Long id, @NotNull @NotBlank(message = "khong duoc de trong") String userName, @NotNull @NotBlank(message = "khong duoc de trong") String password, Integer age, String fullName, @Email @NotEmpty(message = "Email is required") String email, @NotEmpty(message = "role require!") String role, Boolean enabled) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
