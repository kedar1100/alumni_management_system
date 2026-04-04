package com.alumni.service;

import com.alumni.model.*;
import com.alumni.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventRegistrationRepository eventRegistrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlumniProfileRepository alumniProfileRepository;

    // Create Event
    public Event createEvent(Long userId, Map<String, String> data) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found!"));

        Event event = new Event();
        event.setTitle(data.get("title"));
        event.setDescription(data.get("description"));
        event.setLocation(data.get("location"));
        event.setEventDate(LocalDateTime.parse(data.get("eventDate")));
        event.setCreatedBy(user);

        return eventRepository.save(event);
    }

    // Get All Events
    public List<Event> getAllEvents() {
        return eventRepository.findByOrderByEventDateAsc();
    }

    // Get Single Event
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
            .orElseThrow(() -> new RuntimeException("Event not found!"));
    }

    // Register Alumni for Event
    public String registerForEvent(Long eventId, Long alumniId) {
        if (eventRegistrationRepository.existsByEventIdAndAlumniId(eventId, alumniId)) {
            throw new RuntimeException("Already registered for this event!");
        }

        Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new RuntimeException("Event not found!"));

        AlumniProfile alumni = alumniProfileRepository.findById(alumniId)
            .orElseThrow(() -> new RuntimeException("Alumni profile not found!"));

        EventRegistration registration = new EventRegistration();
        registration.setEvent(event);
        registration.setAlumni(alumni);

        eventRegistrationRepository.save(registration);
        return "Successfully registered for: " + event.getTitle();
    }

    // Get All Registrations for an Event
    public List<EventRegistration> getEventRegistrations(Long eventId) {
        return eventRegistrationRepository.findByEventId(eventId);
    }

    // Delete Event
    public String deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
        return "Event deleted successfully!";
    }
}