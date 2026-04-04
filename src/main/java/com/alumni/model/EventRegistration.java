package com.alumni.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_registrations")
public class EventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "alumni_id")
    private AlumniProfile alumni;

    private LocalDateTime registeredAt = LocalDateTime.now();

    // Getters
    public Long getId() { return id; }
    public Event getEvent() { return event; }
    public AlumniProfile getAlumni() { return alumni; }
    public LocalDateTime getRegisteredAt() { return registeredAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setEvent(Event event) { this.event = event; }
    public void setAlumni(AlumniProfile alumni) { this.alumni = alumni; }
    public void setRegisteredAt(LocalDateTime registeredAt) { this.registeredAt = registeredAt; }
}