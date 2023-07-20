package com.rocketscience.rs.controller;

import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/cabinet")
    public Mentor getMentorById(Long id){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        //User user = userService.findByUsername(username);
        //Long id = user.getId();
        return mentorService.findById(id);
    }
    @PostMapping("/cab-save")
    public ResponseEntity<String> saveOrUpdateById(@RequestBody Mentor mentor){
        mentorService.saveOrUpdate(mentor);
        return ResponseEntity.ok("User registered successfully!");
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
