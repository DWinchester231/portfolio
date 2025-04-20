package model;

import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;

public class User implements Comparable<User> {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private char[] password;
    private String language;
    private String status;
    private String privileges;
    private Instant createdAt;
    private String timezone;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(int userId, String firstName, String lastName, String email, String phone, char[] password,
                String language, String status, String privileges, Instant createdAt, String timezone) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = Arrays.copyOf(password, password.length);
        this.language = language;
        this.status = status;
        this.privileges = privileges;
        this.createdAt = createdAt;
        this.timezone = timezone;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public char[] getPassword() {
        return Arrays.copyOf(password, password.length);
    }

    public void setPassword(char[] password) {
        this.password = Arrays.copyOf(password, password.length);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    // equals Method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email);
    }

    // toString Method
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public int compareTo(User o) {
        int result = this.lastName.compareToIgnoreCase(o.lastName);
        if(result == 0) {
            result = this.firstName.compareToIgnoreCase(o.firstName);
        }
        return result;
    }
}