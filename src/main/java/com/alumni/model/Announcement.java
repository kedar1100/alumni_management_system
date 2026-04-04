package com.alumni.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private User postedBy;

    private LocalDateTime postedAt = LocalDateTime.now();

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public User getPostedBy() { return postedBy; }
    public LocalDateTime getPostedAt() { return postedAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setPostedBy(User postedBy) { this.postedBy = postedBy; }
    public void setPostedAt(LocalDateTime postedAt) { this.postedAt = postedAt; }
}