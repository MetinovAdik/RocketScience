package com.rocketscience.rs.controller;

import com.rocketscience.rs.entity.Kwork;
import com.rocketscience.rs.entity.Science;
import com.rocketscience.rs.entity.Subject;
import com.rocketscience.rs.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rocketscience.rs.service.KworkService;

import java.util.List;

@RestController
@RequestMapping("/api/kworks")
public class KworkController {

    private final KworkService kworkService;

    @Autowired
    public KworkController(KworkService kworkService) {
        this.kworkService = kworkService;
    }

    @GetMapping("/by-subject")
    public List<Kwork> getKworksBySubject(@RequestParam Subject subject) {
        return kworkService.findBySubject(subject);
    }

    @GetMapping("/by-type")
    public List<Kwork> getKworksByType(@RequestParam Type type) {
        return kworkService.findByType(type);
    }

    @GetMapping("/by-science")
    public List<Kwork> getKworksByScience(@RequestParam Science science) {
        return kworkService.findByScience(science);
    }
}
