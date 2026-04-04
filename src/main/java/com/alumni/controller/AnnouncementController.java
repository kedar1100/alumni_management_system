package com.alumni.controller;

import com.alumni.model.Announcement;
import com.alumni.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    // Create Announcement
    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createAnnouncement(
            @PathVariable Long userId,
            @RequestBody Map<String, String> data) {
        try {
            Announcement announcement = announcementService.createAnnouncement(userId, data);
            return ResponseEntity.ok("Announcement created: " + announcement.getTitle());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get All Announcements
    @GetMapping("/all")
    public ResponseEntity<List<Announcement>> 
    getAllAnnouncements() {
        return ResponseEntity.ok(announcementService.getAllAnnouncements());
    }

    // Get Single Announcement
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnnouncement(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(announcementService.getAnnouncementById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Delete Announcement
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(announcementService.deleteAnnouncement(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}