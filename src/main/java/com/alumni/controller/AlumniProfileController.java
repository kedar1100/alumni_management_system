package com.alumni.controller;

import com.alumni.model.AlumniProfile;
import com.alumni.service.AlumniProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/alumni")
public class AlumniProfileController {

    @Autowired
    private AlumniProfileService alumniProfileService;

    // Create Profile
    @PostMapping("/profile/{userId}")
    public ResponseEntity<?> createProfile(
            @PathVariable Long userId,
            @RequestBody Map<String, String> data) {
        try {
            AlumniProfile profile = alumniProfileService.createProfile(userId, data);
            return ResponseEntity.ok("Profile created for: " 
                + profile.getFirstName() + " " + profile.getLastName());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get Profile by User ID
    @GetMapping("/profile/{userId}")
    public ResponseEntity<?> getProfile(@PathVariable Long userId) {
        try {
            AlumniProfile profile = alumniProfileService.getProfileByUserId(userId);
            return ResponseEntity.ok(profile);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get All Alumni
    @GetMapping("/all")
    public ResponseEntity<?> getAllProfiles() {
        return ResponseEntity.ok(alumniProfileService.getAllProfiles());
    }

    // Update Profile
    @PutMapping("/profile/{userId}")
    public ResponseEntity<?> updateProfile(
            @PathVariable Long userId,
            @RequestBody Map<String, String> data) {
        try {
            AlumniProfile profile = alumniProfileService.updateProfile(userId, data);
            return ResponseEntity.ok("Profile updated for: " 
                + profile.getFirstName() + " " + profile.getLastName());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}