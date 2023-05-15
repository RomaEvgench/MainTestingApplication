package ru.testingapplication.MainTestingApplication.models;

public class AuthenticationRequest {
    private String username;
    private String password;

    // стандартные геттеры и сеттеры
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
