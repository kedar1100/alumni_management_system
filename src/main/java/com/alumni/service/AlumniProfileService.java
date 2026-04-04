package com.alumni.service;

import com.alumni.model.AlumniProfile;
import com.alumni.model.User;
import com.alumni.repository.AlumniProfileRepository;
import com.alumni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class AlumniProfileService {

    @Autowired
    private AlumniProfileRepository alumniProfileRepository;

    @Autowired
    private UserRepository userRepository;

    // Create Profile
    public AlumniProfile createProfile(Long userId, Map<String, String> data) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found!"));

        if (alumniProfileRepository.findByUserId(userId).isPresent()) {
            throw new RuntimeException("Profile already exists for this user!");
        }

        AlumniProfile profile = new AlumniProfile();
        profile.setUser(user);
        profile.setFirstName(data.get("firstName"));
        profile.setLastName(data.get("lastName"));
        profile.setPhone(data.get("phone"));
        profile.setGender(data.get("gender"));
        profile.setDateOfBirth(data.get("dateOfBirth"));
        profile.setBatchYear(Integer.parseInt(data.get("batchYear")));
        profile.setDepartment(data.get("department"));
        profile.setDegree(data.get("degree"));
        profile.setCurrentCompany(data.get("currentCompany"));
        profile.setCurrentRole(data.get("currentRole"));
        profile.setLocation(data.get("location"));
        profile.setLinkedinUrl(data.get("linkedinUrl"));

        return alumniProfileRepository.save(profile);
    }

    // Get Profile by User ID
    public AlumniProfile getProfileByUserId(Long userId) {
        return alumniProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Profile not found!"));
    }

    // Get All Profiles
    public List<AlumniProfile> getAllProfiles() {
        return alumniProfileRepository.findAll();
    }

    // Update Profile
    public AlumniProfile updateProfile(Long userId, Map<String, String> data) {
        AlumniProfile profile = alumniProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Profile not found!"));

        if (data.get("firstName") != null) profile.setFirstName(data.get("firstName"));
        if (data.get("lastName") != null) profile.setLastName(data.get("lastName"));
        if (data.get("phone") != null) profile.setPhone(data.get("phone"));
        if (data.get("currentCompany") != null) profile.setCurrentCompany(data.get("currentCompany"));
        if (data.get("currentRole") != null) profile.setCurrentRole(data.get("currentRole"));
        if (data.get("location") != null) profile.setLocation(data.get("location"));
        if (data.get("linkedinUrl") != null) profile.setLinkedinUrl(data.get("linkedinUrl"));

        return alumniProfileRepository.save(profile);
    }
}