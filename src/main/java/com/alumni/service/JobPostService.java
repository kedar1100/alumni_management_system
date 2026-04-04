package com.alumni.service;

import com.alumni.model.JobPost;
import com.alumni.model.User;
import com.alumni.repository.JobPostRepository;
import com.alumni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private UserRepository userRepository;

    // Create Job Post
    public JobPost createJobPost(Long userId, Map<String, String> data) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found!"));

        JobPost job = new JobPost();
        job.setTitle(data.get("title"));
        job.setCompany(data.get("company"));
        job.setLocation(data.get("location"));
        job.setDescription(data.get("description"));
        job.setPostedBy(user);

        return jobPostRepository.save(job);
    }

    // Get All Jobs
    public List<JobPost> getAllJobs() {
        return jobPostRepository.findByOrderByPostedAtDesc();
    }

    // Get Single Job
    public JobPost getJobById(Long jobId) {
        return jobPostRepository.findById(jobId)
            .orElseThrow(() -> new RuntimeException("Job post not found!"));
    }

    // Search by Company
    public List<JobPost> searchByCompany(String company) {
        return jobPostRepository.findByCompanyContainingIgnoreCase(company);
    }

    // Search by Location
    public List<JobPost> searchByLocation(String location) {
        return jobPostRepository.findByLocationContainingIgnoreCase(location);
    }

    // Delete Job Post
    public String deleteJobPost(Long jobId) {
        jobPostRepository.deleteById(jobId);
        return "Job post deleted successfully!";
    }
}