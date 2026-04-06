package com.alumni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/events")
    public String events() {
        return "events";
    }
    @GetMapping("/announcements")
    public String announcements() {
        return "announcements";
    }
    @GetMapping("/jobs")
    public String jobs() {
        return "jobs";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/directory")
    public String directory() {
        return "directory";
    }
    @GetMapping("/profile/create")
    public String createProfile() {
        return "create-profile";
    }
}