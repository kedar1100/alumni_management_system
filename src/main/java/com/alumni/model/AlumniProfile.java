package com.alumni.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alumni_profiles")
public class AlumniProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private String dateOfBirth;
    private int batchYear;
    private String department;
    private String degree;
    private String currentCompany;
    private String currentRole;
    private String location;
    private String linkedinUrl;

    // Getters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getGender() { return gender; }
    public String getDateOfBirth() { return dateOfBirth; }
    public int getBatchYear() { return batchYear; }
    public String getDepartment() { return department; }
    public String getDegree() { return degree; }
    public String getCurrentCompany() { return currentCompany; }
    public String getCurrentRole() { return currentRole; }
    public String getLocation() { return location; }
    public String getLinkedinUrl() { return linkedinUrl; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setBatchYear(int batchYear) { this.batchYear = batchYear; }
    public void setDepartment(String department) { this.department = department; }
    public void setDegree(String degree) { this.degree = degree; }
    public void setCurrentCompany(String currentCompany) { this.currentCompany = currentCompany; }
    public void setCurrentRole(String currentRole) { this.currentRole = currentRole; }
    public void setLocation(String location) { this.location = location; }
    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }
}