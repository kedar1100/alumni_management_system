package com.alumni.controller;

import com.alumni.model.JobPost;
import com.alumni.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    // Create Job Post
    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createJob(
            @PathVariable Long userId,
            @RequestBody Map<String, String> data) {
        try {
            JobPost job = jobPostService.createJobPost(userId, data);
            return ResponseEntity.ok("Job posted: " + job.getTitle() + " at " + job.getCompany());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get All Jobs
    @GetMapping("/all")
    public ResponseEntity<List<JobPost>> getAllJobs() {
        return ResponseEntity.ok(jobPostService.getAllJobs());
    }

    // Get Single Job
    @GetMapping("/{jobId}")
    public ResponseEntity<?> getJob(@PathVariable Long jobId) {
        try {
            return ResponseEntity.ok(jobPostService.getJobById(jobId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Search by Company
    @GetMapping("/search/company/{company}")
    public ResponseEntity<List<JobPost>> searchByCompany(@PathVariable String company) {
        return ResponseEntity.ok(jobPostService.searchByCompany(company));
    }

    // Search by Location
    @GetMapping("/search/location/{location}")
    public ResponseEntity<List<JobPost>> searchByLocation(@PathVariable String location) {
        return ResponseEntity.ok(jobPostService.searchByLocation(location));
    }

    // Delete Job Post
    @DeleteMapping("/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable Long jobId) {
        try {
            return ResponseEntity.ok(jobPostService.deleteJobPost(jobId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}