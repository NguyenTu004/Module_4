package com.example.baitap.model;

import javax.validation.constraints.*;

public class User {
    @NotEmpty
    @Size(min = 5, max = 50,message = "false1")
    private String name;
    @Pattern(regexp = "^/d(?:-/d{3}){3}/d$",message = "false2")
    private String phone;
    @Email(message = "false3")
    private String email;
    @Min(value = 18, message = "false4")
    private double age;

    public User() {
    }

    public User(@NotEmpty @Size(min = 5, max = 50) String name, @Pattern(regexp = "^/d(?:-/d{3}){3}/d$") String phone,
                @Email() String email,  @Min(18) double age) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

}
