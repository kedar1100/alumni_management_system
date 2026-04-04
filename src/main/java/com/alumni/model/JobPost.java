package com.alumni.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_posts")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String location;
    private String description;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private User postedBy;

    private LocalDateTime postedAt = LocalDateTime.now();

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCompany() { return company; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public User getPostedBy() { return postedBy; }
    public LocalDateTime getPostedAt() { return postedAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCompany(String company) { this.company = company; }
    public void setLocation(String location) { this.location = location; }
    public void setDescription(String description) { this.description = description; }
    public void setPostedBy(User postedBy) { this.postedBy = postedBy; }
    public void setPostedAt(LocalDateTime postedAt) { this.postedAt = postedAt; }
}