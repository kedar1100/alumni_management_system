package com.alumni.repository;

import com.alumni.model.AlumniProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlumniProfileRepository extends JpaRepository<AlumniProfile, Long> {
    Optional<AlumniProfile> findByUserId(Long userId);
}