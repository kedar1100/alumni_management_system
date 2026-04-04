package com.alumni.service;

import com.alumni.model.Announcement;
import com.alumni.model.User;
import com.alumni.repository.AnnouncementRepository;
import com.alumni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired 
    private UserRepository userRepository;

    public Announcement createAnnouncement(Long userId,Map<String,String> data){
        User user=userRepository.findById(userId)
            .orElseThrow(()->new RuntimeException("User Not Found !"));
        Announcement announcement = new Announcement();
        announcement.setTitle(data.get("title"));
        announcement.setContent(data.get("content"));
        announcement.setPostedBy(user);

        return announcementRepository.save(announcement);
    }
        // Get All Announcements
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAllByOrderByPostedAtDesc();
    }

    // Get Single Announcement
    public Announcement getAnnouncementById(Long id) {
        return announcementRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Announcement not found!"));
    }

    // Delete Announcement
    public String deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
        return "Announcement deleted successfully!";
    }
}