package com.rocketscience.rs.controller;

import com.rocketscience.rs.entity.Application;
import com.rocketscience.rs.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/by-user/{userId}")
    public List<Application> getApplicationsByStudentId(@PathVariable Long playerId) {
        return applicationService.findAllByStudentId(playerId);
    }

    @GetMapping("/by-mentor/{mentorId}")
    public List<Application> getApplicationsByMentorId(@PathVariable Long mentorId) {
        return applicationService.findAllByMentorId(mentorId);
    }
}
