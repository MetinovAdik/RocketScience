package com.rocketscience.rs.controller;

import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentors")
public class MentorController {

    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping
    public List<Mentor> getAllMentors() {
        return mentorService.findAll();
    }

    @GetMapping("/by-services/{services}")
    public List<Mentor> getMentorsByServices(@PathVariable String services) {
        return mentorService.findByServicesContains(services);
    }

    @GetMapping("/by-experience/{minExperience}")
    public List<Mentor> getMentorsByExperience(@PathVariable Double minExperience) {
        return mentorService.findByExperienceAbove(minExperience);
    }
}
