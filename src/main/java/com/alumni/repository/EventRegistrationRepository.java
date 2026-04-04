package com.alumni.repository;

import com.alumni.model.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {
    List<EventRegistration> findByEventId(Long eventId);
    boolean existsByEventIdAndAlumniId(Long eventId, Long alumniId);
}