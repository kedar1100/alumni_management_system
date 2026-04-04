package com.alumni.repository;

import com.alumni.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDateTime;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findAllByOrderByPostedAtDesc();
    List<Announcement> findByPostedAt(LocalDateTime postedAt);  
    List<Announcement> findByTitleContainingIgnoreCase(String title); 
}