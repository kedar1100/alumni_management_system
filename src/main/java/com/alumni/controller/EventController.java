package com.alumni.controller;

import com.alumni.model.Event;
import com.alumni.model.EventRegistration;
import com.alumni.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Create Event
    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createEvent(
            @PathVariable Long userId,
            @RequestBody Map<String, String> data) {
        try {
            Event event = eventService.createEvent(userId, data);
            return ResponseEntity.ok("Event created: " + event.getTitle());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get All Events
    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    // Get Single Event
    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEvent(@PathVariable Long eventId) {
        try {
            return ResponseEntity.ok(eventService.getEventById(eventId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Register for Event
    @PostMapping("/{eventId}/register/{alumniId}")
    public ResponseEntity<?> registerForEvent(
            @PathVariable Long eventId,
            @PathVariable Long alumniId) {
        try {
            return ResponseEntity.ok(eventService.registerForEvent(eventId, alumniId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get Registrations for Event
    @GetMapping("/{eventId}/registrations")
    public ResponseEntity<List<EventRegistration>> getRegistrations(
            @PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.getEventRegistrations(eventId));
    }

    // Delete Event
    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        try {
            return ResponseEntity.ok(eventService.deleteEvent(eventId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}