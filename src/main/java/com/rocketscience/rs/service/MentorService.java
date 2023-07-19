package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.entity.User;
import com.rocketscience.rs.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MentorService {

    private final MentorRepository mentorRepository;

    public List<Mentor> findAll(){return mentorRepository.findAll();}

    //Поиск по предоставляемым услугам
    public List<Mentor> findByServicesContains(String services){
        return mentorRepository.findByServicesContains(services);
    }

    //Поиск по минимальному опыту (Тоесть опыт должен быть больше или равным указанным пользователем)
    public List<Mentor> findByExperienceAbove(Double minExperience){
        return mentorRepository.findByExperienceAboveOrEqual(minExperience);
    }


}
