package com.alumni.repository;

import com.alumni.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    List<JobPost> findByOrderByPostedAtDesc();
    List<JobPost> findByCompanyContainingIgnoreCase(String company);
    List<JobPost> findByLocationContainingIgnoreCase(String location);
}