package ru.testingapplication.MainTestingApplication.models;

public class RegistrationRequest {
    private String role;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Integer courseId;

    // Конструктор, геттеры и сеттеры

    public RegistrationRequest() {
    }

    public RegistrationRequest(String role, String username, String password, String lastName, String firstName, String patronymic, Integer courseId) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.courseId = courseId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
